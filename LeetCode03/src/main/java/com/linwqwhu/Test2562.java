package com.linwqwhu;

/**
 * 2562.找出数组的串联值
 */
public class Test2562 {
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0l;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int n = 0;
            int numRight = nums[right];
            while (numRight != 0) {
                numRight /= 10;
                n++;
            }
            ans = ans + (long) (nums[left] * Math.pow(10, n)) + nums[right];
//            ans = ans + Integer.parseInt("" + nums[left] + nums[right]);
            left++;
            right--;
        }
        if (left == right) {
            ans += nums[left];
        }
        return ans;

    }
}
