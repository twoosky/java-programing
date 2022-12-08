package racingcar.domain;

import java.util.Arrays;

import static racingcar.utils.ErrorMessage.*;

public class CarName {
    public static final String SEPARATOR = ",";
    public CarName(String names) {
        validate(names);
    }

    private void validate(String names) {
        String[] carNames = names.split(SEPARATOR);
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
}
