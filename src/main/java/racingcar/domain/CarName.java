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

}
