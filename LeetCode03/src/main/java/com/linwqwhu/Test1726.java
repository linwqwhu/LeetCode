package com.linwqwhu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1726.同积元组
 */
public class Test1726 {
    public int tupleSameProduct(int[] nums) {
        int res = 0;
        int len = nums.length;
        Arrays.sort(nums);//nums中的元素互不相同

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {

                for (int k = 0; k < len - 1; k++) {
                    for (int l = k + 1; l < len; l++) {
                        if (nums[i] * nums[j] == nums[k] * nums[l] && nums[i] != nums[k] && nums[i] != nums[l]) {
                            res++;
                        }
                    }
                }

            }
        }
        return res * 4;
    }

    public int tupleSameProduct2(int[] nums) {
        int res = 0;
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int num = nums[i] * nums[j];
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int m = entry.getValue();
            res += m * (m - 1);
        }
        return res * 4;
    }

}
