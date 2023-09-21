package cn;

/**
 * 两数相加
 */
public class Test02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int remain = 0;
        ListNode headNode = null;
        ListNode listNode = null;
        boolean first = false;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int val = val1 + val2 + remain;

            remain = val / 10;

            if (!first) {
                listNode = new ListNode(val % 10);
                headNode = listNode;
                first = true;
            }else {
                listNode.next = new ListNode(val % 10);
                listNode = listNode.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (remain == 1) {
            listNode.next = new ListNode(remain);
        }
        return headNode;
    }


}
