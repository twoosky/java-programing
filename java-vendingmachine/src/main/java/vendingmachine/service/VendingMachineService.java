package vendingmachine.service;

import vendingmachine.domain.*;
import vendingmachine.domain.product.ProductPrice;
import vendingmachine.domain.product.Products;
import vendingmachine.dto.ChangeDto;
import vendingmachine.utils.CoinRandomGenerator;

public class VendingMachineService {
    private Money money;
    private VendingMachine vendingMachine;

    public void generateCoin(int amount) {
        VendingMachineAmount vendingMachineAmount = new VendingMachineAmount(amount);
        CoinChanger coinChanger = new CoinChanger(new CoinRandomGenerator());
        coinChanger.generateCoin(vendingMachineAmount);
    }

    public void generateProducts(String productsInfo) {
        Products products = new Products(productsInfo);
        this.vendingMachine = new VendingMachine(products);
    }

    public void generateMoney(int money) {
        this.money = new Money(money);
    }

    public void buyProduct(String product) {
        ProductPrice price = vendingMachine.buyProduct(product);
        money.buyProduct(price);
    }

    public boolean isBuyable() {
        return vendingMachine.isBuyable(money);
    }

    public ChangeDto getChangeDto() {
        return new ChangeDto(new Change(money));
    }

    public Money getMoney() {
        return money;
    }
}
