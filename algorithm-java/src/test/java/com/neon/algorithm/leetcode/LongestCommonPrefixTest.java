package com.neon.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestCommonPrefixTest {

    @Test
    void longestCommonPrefix() {
        var instance = new LongestCommonPrefix();
        Assertions.assertEquals("", instance.longestCommonPrefix(new String[]{""}));
        Assertions.assertEquals("a", instance.longestCommonPrefix(new String[]{"a"}));
        Assertions.assertEquals("a", instance.longestCommonPrefix(new String[]{"ab", "a"}));
    }
}