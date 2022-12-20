package pairmatching.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static pairmatching.utils.ErrorMessages.INVALID_MENU_NUMBER;

public class MenuTest {
    @DisplayName("of 메서드는 메뉴에 존재하는 인자값인 경우 enum을 반환한다.")
    @ParameterizedTest
    @MethodSource("generateData")
    void of_method_input_exists_menuType_return_enum(String type, Menu expect) {
        assertThat(Menu.of(type)).isEqualTo(expect);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
            Arguments.of("1", Menu.CREATE),
            Arguments.of("2", Menu.SELECT),
            Arguments.of("3", Menu.RESET),
            Arguments.of("Q", Menu.QUIT)
        );
    }

    @DisplayName("of 메서드는 메뉴에 존재하지 않는 인자값인 경우 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"4", "5", "6", "메뉴에 엄서용"})
    void of_method_input_not_exists_menuType_IllegalArgumentException(String type) {
        assertThatThrownBy(() -> Menu.of(type))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(INVALID_MENU_NUMBER);
    }
}
