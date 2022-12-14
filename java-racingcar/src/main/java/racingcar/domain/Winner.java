package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Winner {
    private final List<Car> winners;

    public Winner(Cars cars) {
        this.winners = getWinner(cars);
    }

    private List<Car> getWinner(Cars cars) {
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

    public List<String> getNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
