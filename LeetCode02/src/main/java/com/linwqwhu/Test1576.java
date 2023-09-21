package com.linwqwhu;

/**
 * 1576. 替换所有的问号
 */
public class Test1576 {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '?') {
                int j = 0;
                while ((i > 0 && (char) ('a' + j) == chars[i - 1]) || (i < s.length() - 1 && (char) ('a' + j) == chars[i + 1])) {
                    j++;
                }
                chars[i] = (char) ('a' + j);
            }
        }
        return new String(chars);
    }
}
