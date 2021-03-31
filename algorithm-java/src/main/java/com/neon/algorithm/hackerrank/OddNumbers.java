package com.neon.algorithm.hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * Get array of odd numbers from range l <= r
 */
public class OddNumbers {
    public static List<Integer> oddNumbers(int l, int r) {
        if (l > r) return new ArrayList<>();

        int startOffset = l % 2 == 0 ? 1 : 0;
        List<Integer> oddNumbers = new ArrayList<>();

        for (int number = l + startOffset; number <= r; number += 2) {
            oddNumbers.add(number);
        }

        return oddNumbers;
    }
}
