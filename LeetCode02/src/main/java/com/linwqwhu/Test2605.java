package com.linwqwhu;

import java.util.Arrays;

/**
 * 2605. 从两个数字数组里生成最小数字
 */
public class Test2605 {
    public int minNumber1(int[] nums1, int[] nums2) {
        //有相同，取该数
        //无相同，取min1*10 + min2 (min1<min2)
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int min1 = nums1[0];
        int min2 = nums2[0];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    return nums1[i];
                }
            }
        }
        return min1 < min2 ? (min1 * 10 + min2) : (min2 * 10 + min1);
    }

    public int minNumber(int[] nums1, int[] nums2) {
        int[] hash = new int[10];
        for (int x : nums1) {
            hash[x]++;
        }
        for (int y : nums2) {
            hash[y] += 2;
        }

        int min1 = 10;
        int min2 = 10;
        boolean minFlag1 = false;
        boolean minFlag2 = false;
        for (int i = 1; i < 10; i++) {
            if (hash[i] == 3)
                return i;
            else if (!minFlag1 && hash[i] == 1) {
                min1 = i;
                minFlag1 = true;
            } else if (!minFlag2 && hash[i] == 2) {
                min2 = i;
                minFlag2 = true;
            }
        }
        return min1 < min2 ? (min1 * 10 + min2) : (min2 * 10 + min1);
    }
}
