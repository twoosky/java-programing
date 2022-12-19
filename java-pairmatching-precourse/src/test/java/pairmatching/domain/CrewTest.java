package pairmatching.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CrewTest {
    private Crew crew;

    @BeforeEach
    void setUp() {
        crew = new Crew(Course.BACKEND, "하늘");
    }

    @DisplayName("isEqualName 메서드는 이름이 같은 경우 true를 반환한다.")
    @Test
    void isEqualName_same_name_return_true() {
        String name = "하늘";
        assertThat(crew.isEqualName(name)).isTrue();
    }

    @DisplayName("isEqualName 메서드는 이름이 다른 경우 false를 반환한다.")
    @Test
    void isEqualName_different_name_return_false() {
        String name = "이하늘하이";
        assertThat(crew.isEqualName(name)).isFalse();
    }

}
