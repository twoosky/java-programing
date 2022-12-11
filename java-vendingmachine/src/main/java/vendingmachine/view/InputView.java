package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.IntegerConvertor;

import static vendingmachine.utils.ErrorMessages.NOT_INTEGER_CONSUMER_MONEY;
import static vendingmachine.utils.ErrorMessages.NOT_INTEGER_MACHINE_MONEY;

public class InputView {
    public int readAmount() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return IntegerConvertor.parseInt(
                Console.readLine(),
                NOT_INTEGER_MACHINE_MONEY
        );
    }

    public String readProduct() {
        System.out.println();
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        return Console.readLine();
    }

    public int readMoney() {
        System.out.println();
        System.out.println("투입 금액을 입력해 주세요.");
        return IntegerConvertor.parseInt(
                Console.readLine(),
                NOT_INTEGER_CONSUMER_MONEY
        );
    }

    public String readBuyingProduct() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        return Console.readLine();
    }
}
