package racingcar.controller;

import racingcar.domain.GameCount;
import racingcar.domain.RaceGame;
import racingcar.utils.MovingRandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.stream.Stream;

public class RaceGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RaceGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        RaceGame raceGame = startRace();
        playRace(raceGame, getGameCount(raceGame));
        outputView.printWinner(raceGame.getWinner());
    }

    private RaceGame startRace() {
        String names = inputView.readCarName();
        return new RaceGame(names, new MovingRandomNumberGenerator());
    }

    private GameCount getGameCount(RaceGame raceGame) {
        return raceGame.generateGameCount(inputView.readGameCount());
    }

    private void playRace(RaceGame raceGame, GameCount gameCount) {
        outputView.printExecuteResultMessage();
        Stream.generate(raceGame::move)
                .limit(gameCount.getCount())
                .forEach(outputView::printMovingResult);
    }
}
