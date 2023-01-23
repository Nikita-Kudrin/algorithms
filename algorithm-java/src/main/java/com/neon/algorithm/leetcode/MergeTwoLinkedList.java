package com.neon.algorithm.leetcode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * You are given the heads of two sorted linked lists list1 and list2.*
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.*
 * Return the head of the merged linked list.
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 */
public class MergeTwoLinkedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedRoot = new ListNode(0); // Just for the sake of some root (it will not be used as and output)
        ListNode currentMerged = mergedRoot;
        ListNode listOnePointer = list1;
        ListNode listTwoPointer = list2;

        if (listOnePointer == null) return listTwoPointer;
        if (listTwoPointer == null) return listOnePointer;

        while (listOnePointer != null || listTwoPointer != null) {
            if (listOnePointer != null && listTwoPointer != null) {
                if (listOnePointer.val <= listTwoPointer.val) {
                    currentMerged.next = new ListNode(listOnePointer.val);
                    listOnePointer = listOnePointer.next;
                } else {
                    currentMerged.next = new ListNode(listTwoPointer.val);
                    listTwoPointer = listTwoPointer.next;
                }

                currentMerged = currentMerged.next;
            }

            if (listOnePointer == null && listTwoPointer != null) {
                currentMerged.next = new ListNode(listTwoPointer.val);
                listTwoPointer = listTwoPointer.next;
                currentMerged = currentMerged.next;
            }

            if (listTwoPointer == null && listOnePointer != null) {
                currentMerged.next = new ListNode(listOnePointer.val);
                listOnePointer = listOnePointer.next;
                currentMerged = currentMerged.next;
            }
        }

        return mergedRoot.next;
    }
}
