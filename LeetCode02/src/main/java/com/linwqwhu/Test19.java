package com.linwqwhu;


/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class Test19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode right = root;
        ListNode left = root;

        while (n > 0) {
            n--;
            right = right.next;
        }
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;

        return root.next;
    }
}
