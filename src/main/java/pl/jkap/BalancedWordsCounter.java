package pl.jkap;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BalancedWordsCounter {

    public static Integer count(String input) {
        int counter = 0;

        validateInput(input);

        StringBuilder wordToCheck = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                wordToCheck.append(input.charAt(j));
                if (isWordBalanced(wordToCheck)) {
                    counter++;
                }
            }
            wordToCheck = new StringBuilder();
        }

        return counter;
    }

    private static void validateInput(String input) {
        if (input == null || (!input.matches("[a-zA-Z]+") && !input.equals(""))) {
            throw new RuntimeException();
        }
    }

    private static boolean isWordBalanced(StringBuilder wordToCheck) {
        Set<Character> charSet = wordToCheck.chars()
                .mapToObj(chr -> (char) chr)
                .collect(Collectors.toSet());

        List<Long> lettersCounter = new LinkedList<>();
        for (Character character : charSet) {
            lettersCounter.add(wordToCheck.chars().filter(num -> num == character).count());
        }
        return lettersCounter.stream().allMatch(lettersCounter.get(0)::equals);
    }
}
