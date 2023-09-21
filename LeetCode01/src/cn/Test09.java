package cn;

import org.junit.Test;

/**
 * 回文数
 */
public class Test09 {
    public boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int length = String.valueOf(x).length();
        int[] nums = new int[length];
        for (int i = 0; i < length - 1; i++) {
            int num = x / (int) Math.pow(10, length - i - 1);
            for (int j = 0; j < i; j++) {
                num -= Math.pow(10, i - j) * nums[j];
            }
            nums[i] = num;
        }
        nums[length - 1] = x % 10;

        for (int i = 0; i < length / 2; i++) {
            if (nums[i] != nums[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void t() {
        int x = 121;
        System.out.println(isPalindrome(x));
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int length = String.valueOf(x).length();

        char[] chs = String.valueOf(x).toCharArray();

        for (int i = 0; i < length / 2; i++) {
            if (chs[i] != chs[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        long cur = 0;
        int num = x;
        while (num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }
}
