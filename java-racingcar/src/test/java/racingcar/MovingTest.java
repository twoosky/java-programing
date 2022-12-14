package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Cars;
import racingcar.domain.Moving;
import racingcar.utils.MovingRuleGenerator;

public class MovingTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars("two,sky");
    }

    @DisplayName("랜덤값이 4 이상인 경우 이동한다.")
    @ParameterizedTest
    @CsvSource({"4,1", "3,0", "0,0", "9,1"})
    void moveTest(int number, int expectPosition) {
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(number);
        Moving moving = new Moving(testNumberGenerator);

        moving.move(cars);

        cars.getCars().forEach(car ->
                Assertions.assertThat(car.getPosition()).isEqualTo(expectPosition));
    }

    static class TestNumberGenerator implements MovingRuleGenerator<Integer> {
        private final int number;

        TestNumberGenerator(int number) {
            this.number = number;
        }

        @Override
        public Integer generate() {
            return number;
        }
    }
}
