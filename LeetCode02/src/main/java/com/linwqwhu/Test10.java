package com.linwqwhu;

/**
 * 10.正则表达式匹配（weiwancheng）
 */
public class Test10 {
    public boolean isMatch(String s, String p) {

        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            char sc = s.charAt(i);
            char pc = p.charAt(j);
            if (sc == pc) {
                i++;
                j++;
                continue;
            } else if (pc == '.') {
                i++;
                j++;
            } else if (pc == '*') {
                if (j > 0) {
                    if (p.charAt(j - 1) == '.')
                        return true;
                    if (i > 0) {
                        i++;
                        while (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                            i++;
                        }
                    }
                }
            } else {
                return false;
            }
        }
        return i == s.length();
    }
}
