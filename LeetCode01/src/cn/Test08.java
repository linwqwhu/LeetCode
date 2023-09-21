package cn;

import org.junit.Test;

/**
 * 将字符串转换为整数
 */
public class Test08 {
    public int myAtoi(String s) {
        s = s.trim();//去除前面的空格
        if (s.length() == 0) {
            return 0;
        }
        int i = 1;
        StringBuilder sb = new StringBuilder();
        char begin = s.charAt(0);
        if (begin == '-' || begin == '+' || ((int) begin >= 48 && (int) begin < 58)) {
            sb.append(begin);
        } else {
            return 0;
        }
        while (i < s.length() && (int) s.charAt(i) >= 48 && (int) s.charAt(i) < 58) {
            sb.append(s.charAt(i));
            i++;
        }
        if (sb.toString().equals("-") || sb.toString().equals("+")) {
            return 0;
        }

        try {
            return Integer.valueOf(sb.toString());
        } catch (Exception e) {
            return begin == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }

    @Test
    public void t() {
        String s = "   34";
        System.out.println(myAtoi(s));
    }

}
