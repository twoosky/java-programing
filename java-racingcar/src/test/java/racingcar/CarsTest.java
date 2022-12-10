package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Cars;

import static org.assertj.core.api.Assertions.*;
import static racingcar.utils.ErrorMessage.*;

public class CarsTest {
    @DisplayName("자동차 이름을 쉽표로 구분하지 않은 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobiwonijun", "bustaxi"})
    void validateSeparatorTest(String names) {
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_SEPARATOR);
    }

    @DisplayName("경주 자동차가 2개 미만인 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,", ",sky", "붕붕이,"})
    void validateCarCountTest(String name) {
        assertThatThrownBy(() -> new Cars(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LESS_THAN_TWO_CAR_COUNT);
    }

    @DisplayName("자동차 이름이 5자 초과한 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcde,abcdef", "이하늘하이,거꾸로 해도 이하늘하이"})
    void validateNameLengthTest(String name) {
        assertThatThrownBy(() -> new Cars(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OUT_OF_RANGE_NAME_SIZE);
    }

    @DisplayName("중복된 자동차 이름이 있는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"sk,y,sky,sky", "car,car"})
    void validateDuplicateTest(String names) {
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_NAME_CAR_NAME);
    }
}
