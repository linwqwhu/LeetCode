package cn;

import org.junit.Test;

/**
 * 移除链表元素
 */
public class Test203 {
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode newHead = head;
        while (head != null && head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return newHead;
    }

    @Test
    public void t() {
        int[] nums = {1, 2, 2, 1};
        ListNode listNode = new ListNode(nums);
        ListNode listNode1 = removeElements(listNode, 2);
        listNode1.printListNode();
    }
}
