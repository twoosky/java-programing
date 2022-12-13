package pairmatching.controller;

import pairmatching.domain.Menu;
import pairmatching.domain.Mission;
import pairmatching.domain.ReMatching;
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
        Mission mission = repeat(pairMatchingService::generateMission, inputView::readMission);
        match(mission);
    }

    private void match(Mission mission) {
        PairMatchingDto dto = pairMatchingService.match(mission);
        outputView.printPairMatchingResult(dto);
    }

    private void getPair() {
        Mission mission = repeat(pairMatchingService::generateMission, inputView::readMission);
        checkMatched(mission);
        PairMatchingDto dto = pairMatchingService.getPairMatchingResult(mission);
        outputView.printPairMatchingResult(dto);
    }

    private void checkMatched(Mission mission) {
        if (pairMatchingService.isMatched(mission)) {
            ReMatch(mission);
        }
    }

    private void ReMatch(Mission mission) {
        ReMatching reMatching = repeat(ReMatching::of, inputView::readReMatching);
        if (pairMatchingService.isRematching(reMatching)) {
            match(mission);
        }
        if (!pairMatchingService.isRematching(reMatching)) {
            getPair();
        }
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
