package com.linwqwhu;

/**
 * 231. 2 的幂
 */
public class Test231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 == 0) {
            while (true) {

                if (n == 2) {
                    return true;
                } else if (n == 1 || n % 2 == 1) {
                    return false;
                }
                n = n / 2;
            }
        } else {
            return false;
        }
    }
}
