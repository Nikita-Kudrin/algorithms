package com.neon.algorithm.codility;

public class BinarySearchCorrectErrorsInCodeTask {
    // Array is sorted in non-decreasing order
    static int solution(int[] sortedArray, int searchedInteger) {
        if (sortedArray == null) return -1; // or throw IllegalArgumentException ?

        int length = sortedArray.length;
        if (length == 0) {
            return -1;
        }

        int leftBound = 0;
        int rightBound = length - 1;

        while (leftBound < rightBound) {
            int median = (leftBound + rightBound) / 2;
            if (sortedArray[median] > searchedInteger) {
                rightBound = median - 1;
            } else {
                if (leftBound == median) break;
                leftBound = median;
            }
        }

        if (sortedArray[leftBound] == searchedInteger) {
            return leftBound;
        } else if (sortedArray[rightBound] == searchedInteger) {
            return rightBound;
        }

        return -1;
    }
}
