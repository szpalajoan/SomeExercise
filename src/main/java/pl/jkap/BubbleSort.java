package pl.jkap;

import java.util.Arrays;
import java.util.Objects;

public class BubbleSort {

    public static Double[] sort(Double[] input) {
        validateInput(input);

        input = Arrays.stream(input).filter(Objects::nonNull).toArray(Double[]::new);

        boolean isSwapNeeded = true;
        int iteration = 0;
        while (isSwapNeeded) {
            isSwapNeeded = false;
            for (int i = 0; i < input.length - 1 - iteration; i++) {
                if (input[i] > input[i + 1]) {
                    swap(input, i);
                    isSwapNeeded = true;
                }
            }
            iteration++;
        }
        return input;
    }

    private static void validateInput(Double[] input) {
        if (input == null) {
            throw new RuntimeException();
        }
    }

    static void swap(Double[] list, int i) {
        double helper;
        helper = list[i];
        list[i] = list[i + 1];
        list[i + 1] = helper;
    }
}
