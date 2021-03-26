package com.neon.algorithm.codility;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchCorrectErrorsTest {
    private static Stream<Arguments> coreLogicTestDataProvider() {
        return Stream.of(
                // number in array
                Arguments.of(new int[]{1, 2, 5, 9, 9}, 5, 2),
                Arguments.of(new int[]{9}, 9, 0),
                Arguments.of(new int[]{5, 6}, 5, 0),
                Arguments.of(new int[]{5, 6, 7}, 5, 0),
                Arguments.of(new int[]{5, 6, 7, 8}, 5, 0),

                Arguments.of(new int[]{5, 6}, 6, 1),
                Arguments.of(new int[]{5, 6, 7}, 6, 1),
                Arguments.of(new int[]{5, 6, 7, 8}, 6, 1),

                Arguments.of(new int[]{5, 6, 7}, 7, 2),
                Arguments.of(new int[]{5, 6, 7, 8}, 7, 2),


                // number not in array
                Arguments.of(new int[]{1}, 5, -1),
                Arguments.of(new int[]{}, 5, -1),
                Arguments.of(null, 5, -1),
                Arguments.of(new int[]{5, 6}, 7, -1)
        );
    }

    @ParameterizedTest
    @MethodSource({"coreLogicTestDataProvider"})
    void generalLogicTest(final int[] array, int searchedNumber, int expectedPosition) {
        assertThat(BinarySearchCorrectErrorsInCodeTask.solution(array, searchedNumber))
                .isEqualTo(expectedPosition);
    }
}
