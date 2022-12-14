package pairmatching.domain.enums;

import java.util.Arrays;

import static pairmatching.utils.ErrorMessages.INVALID_MENU_NUMBER;

public enum Menu {
    CREATE("1"),
    SELECT("2"),
    RESET("3"),
    QUIT("Q");

    private final String type;

    Menu(String type) {
        this.type = type;
    }

    public static Menu of(String type) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.type.equals(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MENU_NUMBER));
    }

    public boolean isQuit() {
        return this == QUIT;
    }
}
