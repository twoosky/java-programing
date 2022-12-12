package pairmatching.domain;

import static pairmatching.utils.ErrorMessages.INVALID_RE_MATCHING_FLAG;

public class ReMatching {
    public static final String REMATCHING = "네";
    public static final String NOT_REMATCHING = "아니오";

    private final String reMatching;

    public ReMatching(String reMatching) {
        this.reMatching = reMatching;
        validate(reMatching);
    }

    private void validate(String input) {
        if(!isValidReMatchingFlag(input)) {
            throw new IllegalArgumentException(INVALID_RE_MATCHING_FLAG);
        }
    }

    private boolean isValidReMatchingFlag(String input) {
        return input.equals(REMATCHING) || input.equals(NOT_REMATCHING);
    }
}
