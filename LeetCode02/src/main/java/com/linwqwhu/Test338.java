package com.linwqwhu;

/**
 * 338. 比特位计数(weiwancheng)
 */
public class Test338 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }
}
