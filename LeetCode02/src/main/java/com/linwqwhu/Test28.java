package com.linwqwhu;

/**
 * 28.找出字符串中第一个匹配项的下标
 * KMP算法
 */
public class Test28 {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length())
            return -1;
        char[] hayChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        for (int i = 0; i < haystack.length(); i++) {
            if (needleChar[0] == hayChar[i]) {
                for (int j = 0; j < needle.length(); j++) {
                    if (i + j < haystack.length() && hayChar[i + j] != needleChar[j])
                        break;
                    if (j == needle.length() - 1 && i + j < haystack.length() && hayChar[i + j] == needleChar[j])
                        return i;
                }
            }
        }
        return -1;

    }

    public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr3(String haystack, String needle) {


        if (needle == null || needle.length() == 0 || needle.length() > haystack.length())
            return -1;

        int n = haystack.length();
        int m = needle.length();
        char[] hayChar = (" " + haystack).toCharArray();
        char[] needleChar = (" " + needle).toCharArray();

        int[] next = new int[m + 1];
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && needleChar[i] != needleChar[j + 1])
                j = next[j];
            if (needleChar[i] == needleChar[j + 1])
                j++;
            next[i] = j;
        }
        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && hayChar[i] != needleChar[j + 1])
                j = next[j];
            if (hayChar[i] == needleChar[j + 1])
                j++;
            if (j == m)
                return i - m;
        }

        return -1;
    }

}
