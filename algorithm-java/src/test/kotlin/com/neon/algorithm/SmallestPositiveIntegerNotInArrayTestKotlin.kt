package com.neon.algorithm

import com.neon.algorithm.codility.SmallestPositiveIntegerNotInArrayKotlin
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class SmallestPositiveIntegerNotInArrayTestKotlin {
    companion object {
        @JvmStatic
        fun coreLogicTestDataProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(1, 3, 6, 4, 1, 2), 5),
                Arguments.of(intArrayOf(1, 2, 3), 4),
                Arguments.of(intArrayOf(-1, -3), 1),
                Arguments.of(intArrayOf(-1), 1),
                Arguments.of(intArrayOf(0), 1),
                Arguments.of(intArrayOf(), 1),
                Arguments.of(intArrayOf(2, 1, -1), 3),
                Arguments.of(intArrayOf(-1, -5, 14, 1), 2)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("coreLogicTestDataProvider")
    fun generalLogicTest(array: IntArray, expected: Int) {
        Assertions.assertThat(SmallestPositiveIntegerNotInArrayKotlin.Companion.findSmallestPositiveInteger(array))
            .isEqualTo(expected)
    }
}