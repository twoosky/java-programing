package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Money;
import vendingmachine.dto.ChangeDto;

import java.util.Arrays;

import static java.text.MessageFormat.*;
import static vendingmachine.utils.ViewMessages.*;

public class OutputView {

    public void printCoin() {
        System.out.println();
        System.out.println(VENDING_MACHINE_AMOUNT);
        Arrays.stream(Coin.values())
                .map(coin -> getCoinMessage(coin, coin.getCount()))
                .forEach(System.out::println);
    }

    private String getCoinMessage(Coin coin, int count) {
        return format(CHANGE_MESSAGE_FORMAT, coin.getAmount(), count);
    }

    public void printChange(ChangeDto changeDto) {
        System.out.println(CHANGE_MESSAGE);
        changeDto.getChange().entrySet()
                .stream()
                .map(change -> getCoinMessage(change.getKey(), change.getValue()))
                .forEach(System.out::println);
    }

    public void printMoney(Money money) {
        System.out.println();
        System.out.println(format(INPUT_MONEY_FORMAT, money.getMoney()));
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
