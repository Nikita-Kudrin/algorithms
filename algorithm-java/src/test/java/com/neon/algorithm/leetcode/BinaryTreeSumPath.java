package com.neon.algorithm.leetcode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/path-sum/
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals targetSum.
 * <p>
 * A leaf is a node with no children.
 */

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        String textRepresentation = val + "";

        textRepresentation += "," + ((left == null) ? left : left.toString());
        textRepresentation += "," + ((right == null) ? right : right.toString());

        return textRepresentation;
    }

    static TreeNode fromList(List<Integer> items) {
        return initNode(items);
    }

    private static TreeNode initNode(List<Integer> items) {
        if (items == null || items.isEmpty()) return null;

        var nodeValue = items.get(0);
        if (nodeValue == null) return null;
        var node = new TreeNode(items.get(0));

        if (items.size() > 1) // left leaf data available
            node.left = initNode(items.subList(1, items.size()));

        if (items.size() > 2) // right leaf data available
            node.right = initNode(items.subList(2, items.size()));

        return node;
    }
}

class TestData {
    TreeNode node;
    Integer searchedSum;
    boolean expectedResult;

    TestData(TreeNode node, Integer searchedSum, boolean expectedResult) {
        this.node = node;
        this.searchedSum = searchedSum;
        this.expectedResult = expectedResult;
    }
}

public class BinaryTreeSumPath {
    private final Logger log = LogManager.getLogger();

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // are we found leaf ?
        if (root.left == null && root.right == null && (targetSum - root.val == 0))
            return true;
        else {
            var hasPath = false;
            hasPath = hasPathSum(root.left, targetSum - root.val);
            if (hasPath) return hasPath;

            hasPath = hasPathSum(root.right, targetSum - root.val);
            return hasPath;
        }
    }

    List<TestData> inputData = Arrays.asList(
            new TestData(TreeNode.fromList(Arrays.asList(-2, null, -3)), -5, true),
            new TestData(TreeNode.fromList(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)), 22, true),
            new TestData(TreeNode.fromList(Arrays.asList(1, 2, 3)), 5, false),
            new TestData(TreeNode.fromList(Arrays.asList(1, 2)), 0, false)
    );

    @TestFactory
    public Stream<DynamicTest> hasPathSumTest() {
        return inputData.stream()
                .map(testDataItem -> DynamicTest.dynamicTest("hasPathSumDynamicTest",
                        () -> {
                            var hasPath = hasPathSum(testDataItem.node, testDataItem.searchedSum);
                            assertThat(hasPath)
                                    .describedAs("Tree : " + testDataItem.node.toString() + " has path with sum " + testDataItem.searchedSum)
                                    .isEqualTo(testDataItem.expectedResult);
                        }));
    }

    @Test
    void treeTextRepresentation() {
        var tree = TreeNode.fromList(Arrays.asList(-2, null, -3));
        log.info(tree);
    }
}






