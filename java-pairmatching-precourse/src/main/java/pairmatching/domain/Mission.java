package pairmatching.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Mission {
    LEVEL1(Arrays.asList("자동차 경주", "로또", "숫자야구게임")),
    LEVEL2(Arrays.asList("장바구니", "결제", "지하철노선도")),
    LEVEL3(Collections.emptyList()),
    LEVEL4(Arrays.asList("성능개선", "배포")),
    LEVEL5(Collections.emptyList());

    private final List<String> missions;

    Mission(List<String> missions) {
        this.missions = missions;
    }
}
