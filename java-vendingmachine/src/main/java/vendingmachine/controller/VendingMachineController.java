package vendingmachine.controller;

import vendingmachine.service.VendingMachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class VendingMachineController {
    private final InputView inputView;
    private final OutputView outputView;
    private final VendingMachineService vendingMachineService;

    public VendingMachineController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.vendingMachineService = new VendingMachineService();
    }

    public void run() {
        initVendingMachine();
        buyProduct();
        returnChange();
    }

    private void initVendingMachine() {
        repeat(vendingMachineService::generateCoin, inputView::readAmount);
        outputView.printCoin();
        repeat(vendingMachineService::generateProducts, inputView::readProduct);
    }

    private void buyProduct() {
        repeat(vendingMachineService::generateMoney, inputView::readMoney);
        while (vendingMachineService.isBuyable()) {
            outputView.printMoney(vendingMachineService.getMoney());
            repeat(vendingMachineService::buyProduct, inputView::readBuyingProduct);
        }
    }

    private void returnChange() {
        outputView.printMoney(vendingMachineService.getMoney());
        outputView.printChange(vendingMachineService.getChangeDto());
    }

    private <T> void repeat(Consumer<T> object, Supplier<T> input) {
        while (true) {
            try {
                object.accept(input.get());
                return;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
