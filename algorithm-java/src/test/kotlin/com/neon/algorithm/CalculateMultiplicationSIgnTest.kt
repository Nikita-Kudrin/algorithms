package com.neon.algorithm

import com.neon.algorithm.codility.CalculateMultiplicationSign
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CalculateMultiplicationSIgnTest {
    companion object {
        @JvmStatic
        fun coreLogicTestDataProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(1, 3, 6, 4, 1, 2), 1),
                Arguments.of(intArrayOf(1, 0, 3), 0),
                Arguments.of(intArrayOf(-1, -3), 1),
                Arguments.of(intArrayOf(-1), -1),
                Arguments.of(intArrayOf(0), 0),
                Arguments.of(intArrayOf(2, 1, -1), -1),
                Arguments.of(intArrayOf(-1, -5, 14, 1), 1)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("coreLogicTestDataProvider")
    fun generalLogicTest(array: IntArray, expected: Int) {
        Assertions.assertThat(CalculateMultiplicationSign.Companion.solution(array))
            .isEqualTo(expected)
    }
}