package pairmatching.controller;

import pairmatching.domain.Menu;
import pairmatching.domain.ReMatching;
import pairmatching.dto.MissionDto;
import pairmatching.dto.PairMatchingDto;
import pairmatching.service.PairMatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class PairMatchingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final PairMatchingService pairMatchingService;
    private final Map<Menu, Runnable> executor;

    public PairMatchingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.pairMatchingService = new PairMatchingService();
        this.executor = generateExecutor();
    }

    public void run() {
        while (true) {
            Menu menu = getMenu();
            if (menu.isQuit()) {
                break;
            }
            execute(menu);
        }
    }

    private Menu getMenu() {
        outputView.printMenu();
        return repeat(Menu::of, inputView::readMenu);
    }

    private void execute(Menu menu) {
        outputView.printMissionMenu();
        executor.get(menu).run();
    }

    private void matchPair() {
        MissionDto missionDto = repeat(pairMatchingService::generateMission, inputView::readMission);
        checkMatched(missionDto);
    }

    private void match(MissionDto missionDto) {
        PairMatchingDto dto = pairMatchingService.match(missionDto);
        outputView.printPairMatchingResult(dto);
    }

    private void checkMatched(MissionDto dto) {
        if (pairMatchingService.isMatched(dto)) {
            ReMatch(dto);
            return;
        }
        match(dto);
    }

    private void ReMatch(MissionDto dto) {
        ReMatching reMatching = repeat(ReMatching::of, inputView::readReMatching);
        if (pairMatchingService.isRematching(reMatching, dto)) {
            match(dto);
            return;
        }
        matchPair();
    }

    private void getPair() {
        MissionDto missionDto = repeat(pairMatchingService::generateMission, inputView::readMission);
        PairMatchingDto pairMatchingDto = pairMatchingService.getPairMatchingResult(missionDto);
        outputView.printPairMatchingResult(pairMatchingDto);
    }

    private void resetPair() {
        pairMatchingService.reset();
        outputView.printReset();
    }

    private Map<Menu, Runnable> generateExecutor() {
        Map<Menu, Runnable> executor = new EnumMap<>(Menu.class);
        executor.put(Menu.CREATE, this::matchPair);
        executor.put(Menu.SELECT, this::getPair);
        executor.put(Menu.RESET, this::resetPair);
        return executor;
    }

    private <T, R> R repeat(Function<T, R> object, Supplier<T> input) {
        try {
            return object.apply(input.get());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(object, input);
        }
    }

}
