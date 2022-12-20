package vendingmachine.utils;

public class IntegerConvertor {
    public static int parseInt(String input, String message) {
        try {
            return Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
    }
}
