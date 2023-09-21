package com.linwqwhu;

import org.junit.Test;

/**
 * 551.学生出勤记录I
 */
public class Test551 {
    public boolean checkRecord(String s) {
        int flagA = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A')
                flagA++;
            int j = i;
            if (s.charAt(i) == 'L') {
                int k = 1;
                while (j < s.length() - 1 && s.charAt(++j) == 'L')
                    k++;
                if (k >= 3)
                    return false;
            }
            i = i == j ? i : j - 1;
            if (flagA >= 2)
                return false;
        }
        return true;
    }

    public boolean checkRecord2(String s) {
        int countA = 0;
        int countL = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                countA++;
                countL = 0;
                if (countA >= 2)
                    return false;
            } else if (c == 'L') {
                countL++;
                if (countL >= 3)
                    return false;
            } else {
                countL = 0;
            }
        }
        return true;
    }

    @Test
    public void testCheckRecord2() {
        boolean lpll = checkRecord2("LALL");
    }

    public boolean checkRecord3(String s) {
        return !(s.indexOf("LLL") != -1 || s.indexOf("A") != s.lastIndexOf("A"));
    }

}
