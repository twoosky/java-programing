package racingcar.domain;

import static racingcar.utils.ErrorMessage.NOT_INTEGER_GAME_COUNT;

public class GameCount {
    private final int count;

    public GameCount(String gameCount) {
        this.count = toInteger(gameCount);
    }

    private int toInteger(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_GAME_COUNT);
        }
    }
}
