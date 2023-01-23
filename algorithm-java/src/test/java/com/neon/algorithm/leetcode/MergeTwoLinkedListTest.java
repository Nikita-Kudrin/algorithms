package com.neon.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoLinkedListTest {
    @Test
    public void mergeTwoListsTest() {
        var list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        var list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        var instance = new MergeTwoLinkedList().mergeTwoLists(list1, list2);

        do {
            System.out.println(instance.val);
            instance = instance.next;
        } while (instance != null);
    }
}