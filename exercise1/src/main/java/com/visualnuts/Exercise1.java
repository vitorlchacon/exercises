package com.visualnuts;

/**
 * @author Vitor Chacon
 *
 * Exercise1:
 * An algorithm that prints the whole integer numbers to the console, start * from the number 1,
 * and print all numbers going up to the number 100.
 *
 * However, when the number is divisible by 3, do not print the number, but print the word * 'Visual'.
 * If the number is divisible by 5, do not print the number, but print 'Nuts'.
 * And for all numbers divisible by both (eg: the number 15) the same, but print 'Visual Nuts'.
 */
public class Exercise1 {

    public static void main(String[] args) {
        int limit = validateInputAndReturnLimit(args);
        if (limit > 0) {
            for (int i = 1; i <= limit; i++) {
                checkAndPrint(i);
            }
        } else {
            for (int i = -1; i >= limit; i--) {
                checkAndPrint(i);
            }
        }
    }

    private static int validateInputAndReturnLimit(String[] args) throws IllegalArgumentException {
        int limit = 100; // Default limit value
        if (args.length > 0) {
            try {
                limit = Integer.valueOf(args[0]);
                if (limit == 0) {
                    throw new IllegalArgumentException("0 not allowed.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return limit;
    }

    private static void checkAndPrint(int num) {
            if ((num % 3) == 0 && (num % 5) == 0) {
                System.out.println("Visual Nuts");
                return;
            } else if ((num % 3) == 0) {
                System.out.println("Visual");
                return;
            } else if ((num % 5) == 0) {
                System.out.println("Nuts");
                return;
            }
            System.out.println(num);
    }
}
