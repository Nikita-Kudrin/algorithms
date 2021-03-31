package com.neon.algorithm.hackerrank;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class FindTheNumberTest {

    enum BoolToString {
        YES("YES"),
        NO("NO");

        public final String value;

        BoolToString(String value) {
            this.value = value;
        }

        public static BoolToString fromBool(boolean value) {
            return value ? YES : NO;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    private static Stream<Arguments> coreLogicTestDataProvider() {
        return Stream.of(
                // number in array
                Arguments.of(Arrays.asList(1, 2, 5, 9, 9), 5, true),
                Arguments.of(Arrays.asList(9), 9, true),
                Arguments.of(Arrays.asList(5, 6), 5, true),
                Arguments.of(Arrays.asList(5, 6, 7), 7, true),

                // number not in array / edge cases
                Arguments.of(Arrays.asList(1), 5, false),
                Arguments.of(Arrays.asList(), 5, false),
                Arguments.of(null, 5, false),
                Arguments.of(Arrays.asList(5, 6), 7, false)
        );
    }

    @ParameterizedTest
    @MethodSource({"coreLogicTestDataProvider"})
    void generalLogicTest(final List<Integer> array, int searchedNumber, Boolean expected) {
        assertThat(FindTheNumber.findNumber(array, searchedNumber))
                .isEqualTo(BoolToString.fromBool(expected).toString());
    }
}
