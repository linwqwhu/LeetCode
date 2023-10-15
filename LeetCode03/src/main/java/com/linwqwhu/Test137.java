package com.linwqwhu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 137.只出现一次的数字II
 */
public class Test137 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 1; i += 3) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[len - 1];
    }

    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer num : map.keySet()) {
            if (map.get(num) == 1)
                return num;
        }
        return 0;

    }
}
