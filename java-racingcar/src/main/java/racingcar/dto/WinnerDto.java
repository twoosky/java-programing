package racingcar.dto;

import racingcar.domain.Winner;

import java.util.List;

public class WinnerDto {
    private final List<String> names;

    public WinnerDto(Winner winner) {
        this.names = winner.getNames();
    }

    public List<String> getNames() {
        return names;
    }
}
