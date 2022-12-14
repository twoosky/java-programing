package pairmatching.domain.enums;

import java.util.Arrays;

import static pairmatching.utils.ErrorMessages.NOT_EXIST_COURSE;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static Course of(String name) {
        return Arrays.stream(Course.values())
                .filter(course -> course.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_COURSE));
    }

    public String getName() {
        return name;
    }
}
