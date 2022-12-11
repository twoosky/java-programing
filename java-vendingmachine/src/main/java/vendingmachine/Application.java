package vendingmachine;

import vendingmachine.controller.VendingMachineController;

public class Application {
    public static void main(String[] args) {
        try {
            VendingMachineController vendingMachineController = new VendingMachineController();
            vendingMachineController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
