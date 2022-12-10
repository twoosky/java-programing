package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.utils.ErrorMessage.*;

public class Cars {
    public static final String SEPARATOR = ",";

    List<Car> cars;

    public Cars(String names) {
        validate(names);
        this.cars = initCars(names);
    }

    private List<Car> initCars(String names) {
        return Arrays.stream(names.split(SEPARATOR))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validate(String names) {
        List<String> carNames = splitNames(names);
        validateSeparator(names);
        validateCarCount(carNames);
        validateNameLength(carNames);
        validateDuplicate(carNames);
    }

    private List<String> splitNames(String names) {
        return Arrays.stream(names.split(SEPARATOR))
                .filter(name -> name.length() != 0)
                .collect(Collectors.toList());
    }

    private void validateSeparator(String names) {
        if (!names.contains(SEPARATOR)) {
            throw new IllegalArgumentException(INVALID_SEPARATOR);
        }
    }

    private void validateCarCount(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException(LESS_THAN_TWO_CAR_COUNT);
        }
    }

    private void validateDuplicate(List<String> names) {
        long carNameCount = names.stream()
                .distinct().count();
        if (carNameCount != names.size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_CAR_NAME);
        }
    }

    private void validateNameLength(List<String> names) {
        if (getCountByGraterThanFive(names) != 0) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NAME_SIZE);
        }
    }

    private int getCountByGraterThanFive(List<String> names) {
        return (int) names.stream()
                .filter(name -> name.length() > 5)
                .count();
    }

    public List<Car> getCars() {
        return cars;
    }
}
