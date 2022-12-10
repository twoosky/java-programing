package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Winner {
    private final List<Car> winners;

    public Winner(Cars cars) {
        this.winners = getWinners(cars);
    }

    private List<Car> getWinners(Cars cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.getCars().stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition(Cars cars) {
        return cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
