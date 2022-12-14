package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.utils.ViewMessage.INPUT_CAR_NAME;
import static racingcar.utils.ViewMessage.INPUT_GAME_COUNT;

public class InputView {

    public String readCarName() {
        System.out.println(INPUT_CAR_NAME);
        return Console.readLine();
    }

    public String readGameCount() {
        System.out.println(INPUT_GAME_COUNT);
        return Console.readLine();
    }
}
