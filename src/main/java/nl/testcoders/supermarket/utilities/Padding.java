package nl.testcoders.supermarket.utilities;

import lombok.NonNull;

public class Padding {

    private static final String SPACE = " ";

    public static String right(@NonNull final String input, @NonNull final int totalWidth) {
        int repeat = calculateRepeat(input, totalWidth);
        return input + SPACE.repeat(repeat);
    }

    public static String right(@NonNull final int input, @NonNull final int totalWidth) {
        return right(Integer.toString(input), totalWidth);
    }

    public static String right(@NonNull final double input, @NonNull final int totalWidth) {
        return right(Double.toString(input), totalWidth);
    }

    public static String left(@NonNull final String input, @NonNull final int totalWidth) {
        int repeat = calculateRepeat(input, totalWidth);
        return SPACE.repeat(repeat) + input;
    }

    public static String left(@NonNull final int input, @NonNull final int totalWidth) {
        return left(Integer.toString(input), totalWidth);
    }

    public static String left(@NonNull final double input, @NonNull final int totalWidth) {
        return left(Double.toString(input), totalWidth);
    }

    private static int calculateRepeat(@NonNull final String input, @NonNull final int totalWidth) {
        return Math.max(0, totalWidth - input.length());
    }

}
