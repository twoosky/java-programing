package pairmatching.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static pairmatching.utils.ErrorMessages.NOT_EXIST_COURSE;

public class CourseTest {

    @Nested
    @DisplayName("of 메소드는")
    class Describe_of {
        @Nested
        @TestInstance(PER_CLASS)
        @DisplayName("존재하는 과정이름이 입력값으로 주어지면")
        class context_with_exist_course_name {
            @DisplayName("Course 를 반환한다.")
            @ParameterizedTest
            @MethodSource("generateData")
            void it_return_a_value_course(String name, Course expect){
                assertThat(Course.of(name)).isEqualTo(expect);
            }

            Stream<Arguments> generateData() {
                return Stream.of(
                    Arguments.of("프론트엔드", Course.FRONTEND),
                    Arguments.of("백엔드", Course.BACKEND)
                );
            }
        }

        @Nested
        @DisplayName("존재하지 않는 과정이름이 입력값으로 주어지면")
        class context_with_not_exist_course_name {
            @DisplayName("IllegalArgumentException이 발생한다.")
            @ParameterizedTest
            @ValueSource(strings = {"프론트", "엔드", "백", "엔드"})
            void it_return_IllegalArgumentException(String name) {
                assertThatThrownBy(() -> Course.of(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NOT_EXIST_COURSE);
            }
        }
    }
}
