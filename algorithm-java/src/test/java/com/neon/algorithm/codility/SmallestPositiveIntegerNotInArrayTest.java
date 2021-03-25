package com.neon.algorithm.codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SmallestPositiveIntegerNotInArrayTest {

    private static Stream<Arguments> coreLogicTestDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 6, 4, 1, 2}, 5),
                Arguments.of(new int[]{1, 2, 3}, 4),
                Arguments.of(new int[]{-1, -3}, 1),
                Arguments.of(new int[]{-1}, 1),
                Arguments.of(new int[]{0}, 1),
                Arguments.of(new int[]{}, 1),
                Arguments.of(new int[]{2, 1, -1}, 3),
                Arguments.of(new int[]{-1, -5, 14, 1}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource({"coreLogicTestDataProvider"})
    void generalLogicTest(final int[] array, int expected) {
        assertThat(SmallestPositiveIntegerNotInArray.findSmallestPositiveInteger(array)).isEqualTo(expected);
    }

    @Test
    void nullArray() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> SmallestPositiveIntegerNotInArray.findSmallestPositiveInteger(null));
    }
}
