package vendingmachine.dto;

import vendingmachine.domain.Change;
import vendingmachine.domain.Coin;

import java.util.Map;

public class ChangeDto {
    private final Map<Coin, Integer> change;

    public ChangeDto(Change change) {
        this.change = change.getChange();
    }

    public Map<Coin, Integer> getChange() {
        return change;
    }
}
