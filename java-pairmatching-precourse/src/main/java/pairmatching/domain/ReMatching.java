package pairmatching.domain;

import java.util.Arrays;

import static pairmatching.utils.ErrorMessages.INVALID_RE_MATCHING_FLAG;

public enum ReMatching {
    REMATCHING("네"),
    NOT_REMATCHING("아니오");

    private final String command;

    ReMatching(String command) {
        this.command = command;
    }

    public static ReMatching of(String command) {
        return Arrays.stream(ReMatching.values())
                .filter(reMatching -> reMatching.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_RE_MATCHING_FLAG));
    }

    public boolean isReMatching() {
        return this == REMATCHING;
    }
}
