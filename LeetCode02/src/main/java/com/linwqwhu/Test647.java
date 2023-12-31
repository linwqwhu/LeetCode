package com.linwqwhu;

import org.junit.Test;
import sun.reflect.annotation.AnnotationSupport;
import sun.text.normalizer.IntTrie;

/**
 * 647.回文子串
 * 动态规划
 */
public class Test647 {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                res += checkPalindromeSubString(s.substring(i, j));
            }
        }
        return res;
    }

    private int checkPalindromeSubString(String s) {
        StringBuilder stb = new StringBuilder(s).reverse();
        if (s.equals(stb.toString())) return 1;
        return 0;
    }


    @Test
    public void testSubString() {
        String s = "aba";
        int i = countSubstrings(s);
        System.out.println(i);
        System.out.println(s.substring(1, 3));
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */

    public int countSubstrings2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 中心扩展法
     * https://leetcode.cn/problems/palindromic-substrings/solutions/154773/liang-dao-hui-wen-zi-chuan-de-jie-fa-xiang-jie-zho/
     *
     * @param s
     * @return
     */
    public int countSubstrings3(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < i + 2 && j < s.length(); j++) {
                int left = i;
                int right = j;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    res++;
                    left--;
                    right++;
                }
            }
        }
        return res;
    }

    public int countSubstrings4(String s) {
        int ans = 0;
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            // left和right指针和中心点的关系是？
            // 首先是left，有一个很明显的2倍关系的存在，其次是right，可能和left指向同一个（偶数时），也可能往后移动一个（奇数）
            // 大致的关系出来了，可以选择带两个特殊例子进去看看是否满足。
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

}
