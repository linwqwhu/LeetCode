package cn.linwqwhu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class offer60 {

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for(int i = list.size()-1,j=0;i>=0;i--,j++){
            res[j] = list.get(i);
        }
        return  res;
    }

    @Test
    public void testReversePrint(){
        int[] arr = {1,2,3,4};
        ListNode root = new ListNode(arr);
        int[] ints = reversePrint(root);
        System.out.println(ints.toString());
    }
}
