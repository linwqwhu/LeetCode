package cn.linwqwhu;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int[] arr) {

        this.val = arr[0];
        ListNode root = this;

        for (int i = 1; i < arr.length; i++) {
            root.next = new ListNode(arr[i]);
            root = root.next;
        }
    }


    public void printListNode(ListNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
        System.out.println();
    }

    public void printListNode() {
        ListNode root = this;
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
        System.out.println();
    }
}
