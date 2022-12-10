package racingcar.dto;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class GameResultDto {
    private final List<Car> cars;

    public GameResultDto(Cars cars) {
        this.cars = cars.getCars();
    }
}
