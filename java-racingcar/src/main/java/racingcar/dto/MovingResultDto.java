package racingcar.dto;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class MovingResultDto {
    private final List<Car> cars;

    public MovingResultDto(Cars cars) {
        this.cars = cars.getCars();
    }

    public List<Car> getCars() {
        return cars;
    }
}
