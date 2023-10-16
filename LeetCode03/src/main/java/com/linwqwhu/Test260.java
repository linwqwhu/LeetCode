package com.linwqwhu;

import java.util.Arrays;

/**
 * 260.只出现一次的数字III
 */
public class Test260 {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int num1 = nums[0];
        int num2 = nums[len - 1];
        for (int left = 0; left < len - 1; left += 2) {
            if (nums[left] != nums[left + 1]) {
                num1 = nums[left];
                break;
            }
        }
        for (int right = len - 1; right > 0; right -= 2) {
            if (nums[right] != nums[right - 1]) {
                num2 = nums[right];
                break;
            }
        }
        return new int[]{num1, num2};
    }
}
