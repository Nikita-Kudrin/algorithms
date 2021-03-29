package com.neon.algorithm

import com.neon.algorithm.codility.GeneratePalindromeVersion
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class GeneratePalindromeVersionTest {
    private val log: Logger = LogManager.getLogger(GeneratePalindromeVersionTest::class)

    companion object {
        @JvmStatic
        fun coreLogicTestDataProvider(): Stream<Arguments> {
            return Stream.of(
                // able create palindrome
                Arguments.of("?ab??a", ""),
                Arguments.of("?a?", ""),
                Arguments.of("?a", ""),
                Arguments.of("a?", ""),
                Arguments.of("aa", ""),
                Arguments.of("aba", ""),
                Arguments.of("a", ""),
                Arguments.of("??", ""),
                Arguments.of("?", ""),
                Arguments.of("???", ""),

                // impossible to create palindrome
                Arguments.of("bab??a", "NO"),
                Arguments.of("ab", "NO"),
                Arguments.of("ba", "NO")
            )
        }
    }

    @ParameterizedTest
    @MethodSource("coreLogicTestDataProvider")
    fun generalLogicTest(input: String, expected: String) {
        val generatedPalindrome = GeneratePalindromeVersion.Companion.solution(input)

        log.info("Generated: $generatedPalindrome Expected to be a palindrome: $expected")

        if (expected == "NO")
            Assertions.assertThat(generatedPalindrome).isEqualTo("NO")
        else {

            Assertions.assertThat(GeneratePalindromeVersion.Companion.isPalindrome(generatedPalindrome)).isTrue
        }
    }
}