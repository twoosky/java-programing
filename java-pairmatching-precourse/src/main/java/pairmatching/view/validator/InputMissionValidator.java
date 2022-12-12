package pairmatching.view.validator;

import static pairmatching.utils.ErrorMessages.INVALID_MISSION;
import static pairmatching.utils.ErrorMessages.INVALID_MISSION_SEPARATOR;

public class InputMissionValidator {
    public static final String SEPARATOR = ", ";

    public static void validate(String mission) {
        validateSeparator(mission);
        validateMissionInfo(mission);
    }

    private static void validateSeparator(String mission) {
        if (!mission.contains(SEPARATOR)) {
            throw new IllegalArgumentException(INVALID_MISSION_SEPARATOR);
        }
    }

    private static void validateMissionInfo(String mission) {
        if (!isValidMissionInfo(mission)) {
            throw new IllegalArgumentException(INVALID_MISSION);
        }
    }

    private static boolean isValidMissionInfo(String mission) {
        return mission.split(SEPARATOR).length != 3;
    }
}
