package com.neon.algorithm.codility;

public class BinarySearchCorrectErrorsInCodeTask {
    // Array is sorted in non-decreasing order
    static int solution(int[] sortedArray, int searchedInteger) {
        if (sortedArray == null) return -1; // or throw IllegalArgumentException ?

        int length = sortedArray.length;
        if (length == 0) {
            return -1;
        }

        int leftIndex = 0;
        int rightIndex = length - 1;

        while (leftIndex < rightIndex) {
            int medianIndex = (leftIndex + rightIndex) / 2;

            if (sortedArray[medianIndex] == searchedInteger) return medianIndex;

            if (sortedArray[medianIndex] > searchedInteger) {
                rightIndex = medianIndex - 1;
            } else {
                leftIndex = medianIndex + 1;
            }
        }

        if (sortedArray[leftIndex] == searchedInteger) {
            return leftIndex;
        }

        return -1;
    }
}
