package com.linwqwhu;

/**
 * 136.只出现一次的数字
 */
public class Test136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums)
            res ^= num;
        return res;
    }
}
