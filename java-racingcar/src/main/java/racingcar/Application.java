package racingcar;

import racingcar.controller.RaceGameController;

import static racingcar.view.OutputView.*;

public class Application {
    public static void main(String[] args) {
        try {
            RaceGameController raceGameController = new RaceGameController();
            raceGameController.run();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
    }
}
