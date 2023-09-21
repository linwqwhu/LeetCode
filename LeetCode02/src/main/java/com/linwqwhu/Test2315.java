package com.linwqwhu;

import org.junit.Test;

/**
 * 2315.统计星号
 */
public class Test2315 {
    public int countAsterisks(String s) {
        int res = 0;
        boolean flag = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|')
                flag = !flag;
            if (flag && c == '*') {
                res += 1;
            }
        }
        return res;
    }

    @Test
    public void TestCountAsterisks() {
        String s = "l|*e*et|c**o|*de|";
        countAsterisks(s);
    }

}
