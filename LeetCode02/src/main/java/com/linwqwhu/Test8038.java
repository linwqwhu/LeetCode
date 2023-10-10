package com.linwqwhu;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 8038. 收集元素的最少操作次数
 */
public class Test8038 {
    public int minOperations(List<Integer> nums, int k) {
        int len = nums.size();
        Set<Integer> set = new HashSet<>();
        for (int i = len - 1; i >= 0; i--) {
            if (nums.get(i) <= k)
                set.add(nums.get(i));
            if (set.size() == k)
                return len - i;
        }
        return 1;
    }
}
