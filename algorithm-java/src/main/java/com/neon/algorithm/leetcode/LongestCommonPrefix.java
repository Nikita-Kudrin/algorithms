package com.neon.algorithm.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        var sorted = Arrays.stream(strs).sorted().collect(Collectors.toList());
        var first = sorted.get(0);
        var last = sorted.get(sorted.size() - 1);

        // after sorting we need to compare only first and last element till we find difference
        for (var index = 0; index < Math.min(first.length(), last.length()); index++) {
            if (first.charAt(index) != last.charAt(index)) {
                return first.substring(0, index);
            }
        }

        return first;
    }
}
