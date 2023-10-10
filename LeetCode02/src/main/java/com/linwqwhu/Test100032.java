package com.linwqwhu;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 100032. 使数组为空的最少操作次数
 */
public class Test100032 {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            int i = calc(count);
            if (i == -1)
                return -1;
            res += i;
        }
        return res;
    }

    public int calc(int num) {
        int res = 0;
        while (num > 1) {
            if (num == 2 || num == 3)
                return res + 1;
            if (num > 3 && num <= 6)
                return res + 2;
            if (num > 6 && num < 10)
                return res + 3;
            num -= 3;
            res++;
        }
        return num == 1 ? -1 : res;
    }

    @Test
    public void testMinOperations() {
        int[] nums = {14, 12, 14, 14, 12, 14, 14, 12, 12, 12, 12, 14, 14, 12, 14, 14, 14, 12, 12};
        int res = minOperations(nums);
        System.out.println(res);
    }
}
