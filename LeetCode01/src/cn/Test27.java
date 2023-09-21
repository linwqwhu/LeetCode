package cn;

import org.junit.Test;

/**
 * 移除元素
 */
public class Test27 {
    public int removeElement1(int[] nums, int val) {
        int i = 0, j = nums.length - 1;
        for (i = 0; i <= j; i++) {
            while (nums[i] == val && j >= 0) {
                while (nums[j] == val) {
                    j--;
                    if (i > j || j < 0) {
                        return i;
                    }
                }
                nums[i] = nums[j];
                j--;
            }
        }
        return i;
    }

    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left<right){
            if(nums[left]==val){
                nums[left] = nums[right-1];
                right--;
            }else {
                left++;
            }
        }
        return left;
    }

    @Test
    public void t() {
        //int[] nums = {3,2,2,3,3,4,5,0};
        int[] nums = {4, 5};
        int val = 5;
        int k = removeElement(nums, val);
        for (int i = 0; i < k; i++) {
            System.out.println(nums[i]);
        }
    }
}
