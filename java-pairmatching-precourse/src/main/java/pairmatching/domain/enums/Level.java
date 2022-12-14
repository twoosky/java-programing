package pairmatching.domain.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static pairmatching.utils.ErrorMessages.NOT_EXIST_LEVEL;

public enum Level {
    LEVEL1("레벨1", Arrays.asList(Mission.CAR, Mission.LOTTO, Mission.BASEBALL)),
    LEVEL2("레벨2", Arrays.asList(Mission.BUCKET, Mission.PAY, Mission.SUBWAY)),
    LEVEL3("레벨3", Collections.emptyList()),
    LEVEL4("레벨4", Arrays.asList(Mission.PERFORMANCE, Mission.DEPLOY)),
    LEVEL5("레벨5", Collections.emptyList());

    private final String name;
    private final List<Mission> missions;

    Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static void validate(String name) {
        Arrays.stream(Level.values())
                .filter(level -> level.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_LEVEL));
    }

    public String getName() {
        return name;
    }

    public List<Mission> getMissions() {
        return missions;
    }
}
