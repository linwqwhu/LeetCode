package cn;

import java.util.List;

/**
 * 辅助链点
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int[] vals) {
        this.val = vals[0];
        ListNode newNode = this;
        for (int i = 1; i < vals.length; ++i) {
            newNode.next = new ListNode(vals[i]);
            newNode = newNode.next;
        }
    }


    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void printListNode(ListNode root){
        while (root!=null){
            System.out.print(root.val+" ");
            root = root.next;
        }
        System.out.println();
    }

    public void printListNode(){
        ListNode root = this;
        while (root!=null){
            System.out.print(root.val+" ");
            root = root.next;
        }
        System.out.println();
    }
}
