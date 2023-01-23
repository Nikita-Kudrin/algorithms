package com.neon.algorithm.leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * Solution: for support very big numbers (more then long and BigInt) we should implement addition by a column method
 * </p>
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode firstList, ListNode secondList) {
        if (firstList == null || secondList == null)
            throw new IllegalArgumentException("Lists should not be null");

        int tempNumber = 0;
        ListNode sumList = null, currentSumNode = null;
        ListNode firstPointer = firstList, secondPointer = secondList;
        int firstNumber = 0, secondNumber = 0;

        do {
            if (firstPointer == null)
                firstNumber = 0;
            else
                firstNumber = firstPointer.val;

            if (secondPointer == null)
                secondNumber = 0;
            else
                secondNumber = secondPointer.val;

            if (firstNumber > 9 || secondNumber > 9)
                throw new IllegalArgumentException("Digit of the number should be less then 9");

            var sum = firstNumber + secondNumber + tempNumber;

            if (sum > 9) {
                tempNumber = 1;
                sum = sum % 10;
            } else {
                tempNumber = 0;
            }

            if (sumList == null) {
                sumList = new ListNode(sum);
                currentSumNode = sumList;
            } else {
                currentSumNode.next = new ListNode(sum);
                currentSumNode = currentSumNode.next;
            }

            if (firstPointer != null) {
                firstPointer = firstPointer.next;
            }
            if (secondPointer != null) {
                secondPointer = secondPointer.next;
            }

            if (firstPointer == null && secondPointer == null && tempNumber > 0)
                currentSumNode.next = new ListNode(tempNumber);
        }
        while (firstPointer != null || secondPointer != null);

        return sumList;
    }

    private static boolean hasNext(ListNode list) {
        return list.next != null;
    }
}
