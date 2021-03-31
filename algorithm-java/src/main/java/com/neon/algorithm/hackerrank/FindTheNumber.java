package com.neon.algorithm.hackerrank;

import java.util.List;

/**
 * Return YES - if number exist in the array, otherwise - NO
 */
public class FindTheNumber {
    public static String findNumber(List<Integer> arr, int k) {
        if (arr == null || arr.isEmpty()) return "NO";

        return arr.contains(k) ? "YES" : "NO";
    }
}
