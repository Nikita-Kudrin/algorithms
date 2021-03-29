package com.neon.algorithm.leetcode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;


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
    private static final Logger log = LogManager.getLogger();

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

    /**
     * Breadth-first print tree
     */
    @Override
    public String toString() {
        var queue = new LinkedList<TreeNode>();
        queue.add(this);

        String textRepresentation = "";

        while (!queue.isEmpty()) {
            var node = queue.remove();

            if (node == null) textRepresentation += "null, ";
            else {
                textRepresentation += node.val + ", ";

                if (node.left == null && node.right == null) continue;

                queue.add(node.left);
                queue.add(node.right);
            }
        }

        if (textRepresentation.endsWith(", ")) return textRepresentation.substring(0, textRepresentation.length() - 2);
        return textRepresentation;
    }

    static TreeNode fromInt(Integer val) {
        if (val == null) return null;
        else return new TreeNode(val);
    }

    /**
     * Breadth-first tree init
     */
    static TreeNode fromList(List<Integer> items) {
        if (items == null || items.isEmpty()) return null;

        var nodeIndex = 0;

        var root = new TreeNode(items.get(nodeIndex++));
        var queue = new LinkedList<TreeNode>();
        queue.add(root);

        try {
            while (!queue.isEmpty() && nodeIndex < items.size()) {
//                log.info(queue);
                var item = queue.remove();

                if (item == null) {
                    nodeIndex += 2; // skip 2 null children
                    continue;
                }

                if (nodeIndex + 1 <= items.size()) {
                    item.left = TreeNode.fromInt(items.get(nodeIndex++));
                    queue.add(item.left);
                }
                if (nodeIndex + 1 <= items.size()) {
                    item.right = TreeNode.fromInt(items.get(nodeIndex++));
                    queue.add(item.right);
                }
            }
        } catch (Exception ex) {
            log.error(root.toString());
            throw ex;
        }

        return root;
    }
}

public class BinaryTreeSumPath {
    private final Logger log = LogManager.getLogger();

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // found a leaf
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
}
