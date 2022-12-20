package pairmatching.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static pairmatching.utils.ErrorMessages.NOT_EXIST_LEVEL;

public class LevelTest {
    @DisplayName("존재하지 않는 레벨이 입력값을 주어지면 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"레벨0, 레벨"})
    void it_return_IllegalArgumentException(String level) {
        Assertions.assertThatThrownBy(() -> Level.validate(level))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_EXIST_LEVEL);
    }
}
