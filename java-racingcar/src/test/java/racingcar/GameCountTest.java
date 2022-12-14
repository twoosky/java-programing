package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.GameCount;

import static racingcar.utils.ErrorMessage.NOT_INTEGER_GAME_COUNT;

public class GameCountTest {
    @DisplayName("게임 시도 횟수 입력값이 숫자가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "two", "one"})
    void toIntegerTest(String input) {
        Assertions.assertThatThrownBy(() -> new GameCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_INTEGER_GAME_COUNT);
    }
}
