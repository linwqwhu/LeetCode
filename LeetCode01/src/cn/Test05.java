package cn;

import org.junit.Test;

/**
 * 最长回文子串
 */
public class Test05 {
    public String longestPalindrome(String s) {
        int len = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < i + 2 && j < len; j++) {
                int left = i, right = j;
                while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
                if ((right - left) >= (end - start)) {
                    start = left;
                    end = right;
                }
            }
        }
        return s.substring(start + 1, end);//[start+1,end-1]才是答案
    }

    @Test
    public void testLongestPalindrome() {
        String s = "babad";
        String res = longestPalindrome(s);
        System.out.println(res);
    }


}
