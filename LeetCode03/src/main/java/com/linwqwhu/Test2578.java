package com.linwqwhu;

import java.util.Arrays;

/**
 * 2578.最小和分割
 */
public class Test2578 {
    public int splitNum(int num) {
        int num1 = 0, num2 = 0;
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (char c : chars) {
            if (num1 > num2) {
                num2 = num2 * 10 + c - '0';
            } else {
                num1 = num1 * 10 + c - '0';
            }
        }
        return num1 + num2;

    }
}
