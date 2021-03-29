package com.neon.algorithm.leetcode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

public class BinaryTreeSumPathTest {
    private final Logger log = LogManager.getLogger();


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
                            var hasPath = BinaryTreeSumPath.hasPathSum(testDataItem.node, testDataItem.searchedSum);
                            Assertions.assertThat(hasPath)
                                    .describedAs("Tree : \"" + testDataItem.node.toString() + "\" has path with sum " + testDataItem.searchedSum)
                                    .isEqualTo(testDataItem.expectedResult);
                        }));
    }

    @Test
    void treeTextRepresentation() {
        var tree = TreeNode.fromList(Arrays.asList(-2, null, -3));
        log.info(tree);

        tree = TreeNode.fromList(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1));
        log.info(tree);

        tree = TreeNode.fromList(Arrays.asList(1, 2, 3));
        log.info(tree);

        tree = TreeNode.fromList(Arrays.asList(1, 2));
        log.info(tree);
    }
}
