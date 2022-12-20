package pairmatching.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.TestInstance.Lifecycle.*;
import static pairmatching.utils.ErrorMessages.NOT_EXIST_MISSION;

public class MissionTest {
    @Nested
    @DisplayName("of 메서드는")
    class Describe_of {
        @Nested
        @TestInstance(PER_CLASS)
        @DisplayName("존재하는 미션이름이 입력값으로 주어지면")
        class context_with_exist_mission_name {
            @DisplayName("Mission을 반환한다.")
            @ParameterizedTest
            @MethodSource("generateData")
            void it_return_a_value_mission(String name, Mission expect) {
                Assertions.assertThat(Mission.of(name)).isEqualTo(expect);
            }

            Stream<Arguments> generateData() {
                return Stream.of(
                    Arguments.of("자동차경주", Mission.CAR),
                    Arguments.of("로또", Mission.LOTTO),
                    Arguments.of("지하철노선도", Mission.SUBWAY),
                    Arguments.of("배포", Mission.DEPLOY)
                );
            }
        }

        @Nested
        @DisplayName("존재하지 않는 미션이름이 입력값으로 주어지면")
        class context_with_not_exist_course_name {
            @DisplayName("IllegalArgumentException이 발생한다.")
            @ParameterizedTest
            @ValueSource(strings = {"자동차", "없는 미션", "미션100"})
            void it_return_IllegalArgumentException(String name) {
                assertThatThrownBy(() -> Mission.of(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NOT_EXIST_MISSION);
            }
        }
    }
}
