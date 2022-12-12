package pairmatching.domain;

import java.util.Arrays;

import static pairmatching.utils.ErrorMessages.NOT_EXIST_LEVEL;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Level(String name) {
        this.name = name;
    }

    public static Level of(String name) {
        return Arrays.stream(Level.values())
                .filter(level -> level.name == name)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_LEVEL));
    }
}
