package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.utils.ErrorMessage.*;

public class Cars {
    public static final String SEPARATOR = ",";

    List<Car> cars;

    public Cars(String names) {
        String[] carNames = names.split(SEPARATOR);
        validate(carNames);
        this.cars = initCars(carNames);
    }

    private List<Car> initCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validate(String[] carNames) {
        validateSeparator(carNames);
        validateQuantity(carNames);
        validateDuplicate(carNames);
    }

    private void validateSeparator(String[] names) {
        if (names.length == 0) {
            throw new IllegalArgumentException(INVALID_SEPARATOR);
        }
    }

    private void validateQuantity(String[] names) {
        if (names.length < 2) {
            throw new IllegalArgumentException(LESS_THAN_TWO);
        }
    }

    private void validateDuplicate(String[] names) {
        long carNameCount = Arrays.stream(names)
                .distinct().count();
        if (carNameCount != names.length) {
            throw new IllegalArgumentException(DUPLICATED_NAME);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
