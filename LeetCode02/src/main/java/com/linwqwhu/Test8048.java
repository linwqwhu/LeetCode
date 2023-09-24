package com.linwqwhu;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 8048.最大二进制奇数
 */
public class Test8048 {
    public String maximumOddBinaryNumber(String s) {
        int count = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        int[] nums = new int[len];
        nums[len - 1] = 1;
        for (int i = 0; i < count - 1; i++) {
            nums[i] = 1;
        }
        return Arrays.stream(nums).mapToObj(Integer::toString).collect(Collectors.joining());
    }

    @Test
    public void testMaximumOddBinaryNumber() {
        String s = "0111";
        String res = maximumOddBinaryNumber(s);
        System.out.println(res);
    }
}
