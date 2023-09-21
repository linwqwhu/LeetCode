package cn;

import org.junit.Test;

/**
 * 合并两个有序链表
 */
public class Test21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = null;
        ListNode headNode = null;
        boolean flag = false;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        while (list1 != null || list2 != null) {
            int value1 = list1 != null ? list1.val : Integer.MAX_VALUE;
            int value2 = list2 != null ? list2.val : Integer.MAX_VALUE;

            if (!flag) {
                listNode = value1 <= value2 ? list1 : list2;
                headNode = listNode;
                if (value1 > value2) {
                    list2 = list2.next;
                }
                if (value1 <= value2) {
                    list1 = list1.next;
                }
                flag = true;
            } else {
                if (value1 <= value2) {
                    listNode.next = list1;
                    listNode = listNode.next;
                    list1 = list1.next;
                } else {
                    listNode.next = list2;
                    listNode = listNode.next;
                    list2 = list2.next;
                }
            }
        }
        return headNode;
    }

    @Test
    public void t() {
        int[] vals = {1, 2, 3, 4};
        int[] vals2 = {};
        ListNode list1 = new ListNode(vals);
        //ListNode list2 = new ListNode(vals2);
        ListNode list2 = new ListNode();
        //list1.printListNode(list1);

        //list2.printListNode();
        ListNode listNode = mergeTwoLists(list1, list2);
        listNode.printListNode(listNode);
    }
}
