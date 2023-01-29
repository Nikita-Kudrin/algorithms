package com.neon.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/permutations-ii/description/
 * <p>
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 * <p>
 * Input: nums = [1,1,2]
 * Output: [[1,1,2],  [1,2,1],  [2,1,1]]
 */
public class GenerateUniquePermutations {
    private Map<String, List<Integer>> permutationsMap = new HashMap<String, List<Integer>>();

    /**
     * Generating permutation using Heap Algorithm
     * https://www.geeksforgeeks.org/heaps-algorithm-for-generating-permutations/
     */
    private void heapPermutation(int[] array, int size, int n) {
        // if size becomes 1 then prints the obtained permutation
        if (size == 1) {
            var candidate = new ArrayList<Integer>(n);
            var stringBuilder = new StringBuilder();

            for (var index = 0; index < n; index++) {
                candidate.add(array[index]);

                stringBuilder.append('_');
                stringBuilder.append(array[index]);
            }

            // filtering non unique permutations
            var stringRepresentation = stringBuilder.toString();
            if (!permutationsMap.containsKey(stringRepresentation)) {
                permutationsMap.put(stringRepresentation, candidate);
            }
        }

        for (int i = 0; i < size; i++) {
            heapPermutation(array, size - 1, n);

            // if size is odd, swap 0th i.e (first) and (size-1)th i.e (last) element
            if (size % 2 == 1) {
                int temp = array[0];
                array[0] = array[size - 1];
                array[size - 1] = temp;
            }
            // If size is even, swap ith and (size-1)th i.e last element
            else {
                int temp = array[i];
                array[i] = array[size - 1];
                array[size - 1] = temp;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        heapPermutation(nums, nums.length, nums.length);
        return permutationsMap.values().stream().collect(Collectors.toList());
    }
}

