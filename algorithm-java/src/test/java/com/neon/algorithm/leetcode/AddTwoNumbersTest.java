package com.neon.algorithm.leetcode;

import org.apache.commons.lang3.ArrayUtils;
import org.javatuples.Pair;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class AddTwoNumbersTest {
    private ListNode convertLongToList(long number) {
        var strNumber = Long.valueOf(number).toString();
        ListNode sumList = null, currentNode = null;

        var charArray = strNumber.toCharArray();

        for (var index = charArray.length - 1; index >= 0; index--) {
            int digit = Character.getNumericValue(charArray[index]);

            if (sumList == null) {
                sumList = new ListNode(digit);
                currentNode = sumList;
            } else {
                currentNode.next = new ListNode(digit);
                currentNode = currentNode.next;
            }
        }

        return sumList;
    }

    private String convertListToString(ListNode list) {
        StringBuilder builder = new StringBuilder();

        var currentNode = list;

        while (currentNode != null) {
            builder.append(currentNode.val);
            currentNode = currentNode.next;
        }

        var reversedChars = builder.toString().toCharArray();
        ArrayUtils.reverse(reversedChars);

        return String.valueOf(reversedChars);
    }

    List<Pair<Long, Long>> testData = Arrays.asList(
            new Pair<Long, Long>(0L, 0L),
            new Pair<Long, Long>(1L, 1L),
            new Pair<Long, Long>(8L, 44L),
            new Pair<Long, Long>(44L, 8L),

            new Pair<Long, Long>(14L, 20L),
            new Pair<Long, Long>(342L, 465L),
            new Pair<Long, Long>(465L, 342L),

            new Pair<Long, Long>(999L, 999L),
            new Pair<Long, Long>(10000989890000000L, 2323232323232232L)
    );

    @TestFactory
    public Stream<DynamicTest> addTwoNumbers_DynamicTests() {
        return testData.stream()
                .map(numberPair -> DynamicTest.dynamicTest("addTwoNumbers_DynamicTests",
                        () -> {
                            var firstNumber = numberPair.getValue0();
                            var secondNumber = numberPair.getValue1();
                            var firstList = convertLongToList(firstNumber);
                            var secondList = convertLongToList(secondNumber);
                            var expected = firstNumber + secondNumber;

                            var sumList = AddTwoNumbers.addTwoNumbers(firstList, secondList);
                            var actual = Long.valueOf(convertListToString(sumList));

                            assertThat(expected)
                                    .describedAs(String.format("First: %s Second: %s", firstNumber, secondNumber))
                                    .isEqualTo(actual);
                        }
                ));
    }
}
