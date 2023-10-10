package com.linwqwhu;

import java.util.Arrays;

/**
 * 2731.移动机器人
 */
public class Test2731 {
    public int sumDistance(int[] nums, String s, int d) {
        int len = nums.length;
        long[] robot = new long[len];
        for (int i = 0; i < len; i++) {
            robot[i] = nums[i] + (s.charAt(i) == 'L' ? -1 : 1) * d;
        }
        Arrays.sort(robot);
        long res = 0;
        for (int i = 0; i < len; i++) {
            res += (-len + 1 + 2 * i) * robot[i];
            res %= (int) (1e9 + 7);
        }
        return (int) res;
    }
}
