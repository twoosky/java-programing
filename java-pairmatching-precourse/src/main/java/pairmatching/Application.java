package pairmatching;

import pairmatching.controller.PairMatchingController;

public class Application {
    public static void main(String[] args) {
        try {
            PairMatchingController pairMatchingController = new PairMatchingController();
            pairMatchingController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
