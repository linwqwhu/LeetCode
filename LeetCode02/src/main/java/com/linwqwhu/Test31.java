package com.linwqwhu;

import java.nio.channels.NonReadableChannelException;

/**
 * 31.下一个排列
 */
public class Test31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return;
        int i = len - 2, j = len - 1, k = len - 1;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        j = i + 1;

        if (i >= 0) {
            while (k >= j && nums[i] >= nums[k]) {
                k--;
            }

            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
        for (i = j, j = len - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
