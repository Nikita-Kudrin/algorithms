package com.neon.algorithm.codility;

import java.util.Arrays;

/**
 * Find smallest positive integer > 0 that does not occur in array
 */
public class SmallestPositiveIntegerNotInArray {
    public static int findSmallestPositiveInteger(int[] array) {
        if (array == null) throw new IllegalArgumentException("Array should not be zero");
        if (array.length == 0) return 1;

        Arrays.sort(array);

        var positiveNumbers = Arrays.stream(array).distinct().filter(item -> item > 0).toArray();
        if (positiveNumbers.length == 0) return 1;

        for (var index = 0; index < positiveNumbers.length - 1; index++) {
            if (positiveNumbers[index] + 1 != positiveNumbers[index + 1])
                return positiveNumbers[index] + 1;
        }

        int min = 0, max = 0;

        if (positiveNumbers.length == 1)
            min = max = positiveNumbers[0];
        else {
            min = positiveNumbers[0];
            max = positiveNumbers[positiveNumbers.length - 1];
        }

        var result = min - 1;
        if (result > 0) return min - 1;
        else return max + 1;
    }
}
