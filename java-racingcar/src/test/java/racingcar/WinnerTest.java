package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WinnerTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars("pobi,woni,jun");
    }

    @DisplayName("우승자 이름을 반환한다.")
    @ParameterizedTest
    @MethodSource("generateData")
    void getNamesByWinnerTest(List<Integer> repeatCount, List<String> expect) {
        generateCarsByPosition(repeatCount);
        Winner winner = new Winner(cars);

        Assertions.assertThat(winner.getNames())
                .usingRecursiveComparison()
                .isEqualTo(expect);
    }
    
    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(3, 2, 3), Arrays.asList("pobi", "jun")),
                Arguments.of(Arrays.asList(0, 0, 0), Arrays.asList("pobi", "woni", "jun")),
                Arguments.of(Arrays.asList(1, 5, 4), Arrays.asList("woni"))
        );
    }

    private void generateCarsByPosition(List<Integer> repeatCount) {
        IntStream.range(0, 3)
                .boxed()
                .forEach(index -> updatePosition(index, repeatCount.get(index)));
    }
    
    private void updatePosition(int index, int repeat) {
        Car car = cars.getCars().get(index);
        IntStream.range(0, repeat)
                .boxed()
                .forEach(i -> car.move(true));
    }
}
