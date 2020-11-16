package nl.testcoders.supermarket.utilities;

public class Formatter {

    public static String asAmount(final double amount) {
        return asAmount(amount, false);
    }

    public static String asAmount(final double amount, final boolean includeEuroSign) {
        String amountFormatted = String.format("%.2f", amount);
        if (includeEuroSign) {
            return "€" + amountFormatted;
        }
        return amountFormatted;
    }



}
