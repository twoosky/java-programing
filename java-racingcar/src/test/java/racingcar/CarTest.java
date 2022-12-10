package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("sky");
    }

    @DisplayName("전진할 수 있는 경우 position을 업데이트한다.")
    @ParameterizedTest
    @CsvSource({"true,1", "false,0"})
    void carMoveTest(boolean isMove, int expectPosition) {
        car.move(isMove);
        assertThat(car.getPosition()).isEqualTo(expectPosition);
    }

    @DisplayName("car의 position이 max값인 경우 true를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1,false", "0,true"})
    void carIsWinnerTest(int max, boolean expect) {
        assertThat(car.isWinner(max)).isEqualTo(expect);
    }
}
