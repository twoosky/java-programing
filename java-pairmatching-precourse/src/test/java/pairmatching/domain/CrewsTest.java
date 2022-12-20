package pairmatching.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CrewsTest {
    private static TestCrews testCrews;

    @BeforeAll
    static void setUp() {
        testCrews = new TestCrews();
    }


    @DisplayName("getCrewsName은 크루들의 이름을 반환한다.")
    @ParameterizedTest
    @EnumSource(Course.class)
    void getCrewsName_input_Course_return_names(Course course) {
        Assertions.assertThat(testCrews.getCrewsName(course))
            .isEqualTo(testCrews.getNamesByCourse(course));
    }

    static class TestCrews extends Crews {
        private Map<Course, List<Crew>> crews;
        private List<String> frontEndName = List.of("네이마르", "음바페", "하늘");
        private List<String> backEndName = List.of("메시", "손흥민", "이하늘");
        TestCrews() {
            crews = initCrews();
        }

        private Map<Course, List<Crew>> initCrews() {
            Map<Course, List<Crew>> crews = new EnumMap<>(Course.class);
            crews.put(Course.FRONTEND, toCrew(Course.FRONTEND, frontEndName));
            crews.put(Course.BACKEND, toCrew(Course.BACKEND, backEndName));
            return crews;
        }

        private List<Crew> toCrew(Course course, List<String> names) {
            return names.stream()
                .map(name -> new Crew(course, name))
                .collect(Collectors.toList());
        }

        public List<String> getNamesByCourse(Course course) {
            if (course == Course.FRONTEND) {
                return frontEndName;
            }
            return backEndName;
        }
    }
}
