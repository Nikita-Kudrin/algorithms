package com.neon.algorithm

import com.neon.algorithm.codility.GeneratePalindromeVersion
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class GeneratePalindromeVersionTest {
    companion object {
        @JvmStatic
        fun coreLogicTestDataProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("?ab??a", "aabbaa"),
                Arguments.of("bab??a", "NO"),
                Arguments.of("?a?", "aaa")
            )
        }
    }

    @ParameterizedTest
    @MethodSource("coreLogicTestDataProvider")
    fun generalLogicTest(input: String, expected: String) {
        Assertions.assertThat(GeneratePalindromeVersion.Companion.solution(input))
            .isEqualTo(expected)
    }
}