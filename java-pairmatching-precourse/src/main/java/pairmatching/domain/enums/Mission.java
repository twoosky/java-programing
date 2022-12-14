package pairmatching.domain.enums;

import java.util.Arrays;

import static pairmatching.utils.ErrorMessages.NOT_EXIST_MISSION;

public enum Mission {
    CAR("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    BUCKET("장바구니"),
    PAY("결제"),
    SUBWAY("지하철노선도"),
    PERFORMANCE("성능개선"),
    DEPLOY("배포");

    private final String name;

    Mission(String name) {
        this.name = name;
    }

    public static Mission of(String name) {
        return Arrays.stream(Mission.values())
                .filter(mission -> mission.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_MISSION));
    }

    public String getName() {
        return name;
    }
}
