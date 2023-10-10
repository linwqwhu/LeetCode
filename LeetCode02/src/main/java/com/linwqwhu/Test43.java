package com.linwqwhu;

import org.junit.Test;

/**
 * 43.字符串相乘
 */
public class Test43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        String res1 = "0", res2 = "0";
        for (int j = 0; j < len2; j++) {
            int m = 0;
            int x = num2.charAt(j) - '0';
            StringBuffer sb = new StringBuffer();
            for (int i = len1 - 1; i >= 0; i--) {
                int y = num1.charAt(i) - '0';
                int sum = x * y + m;
                m = sum / 10;
                sum %= 10;
                sb.append(sum);
            }
            if (m > 0)
                sb.append(m);
            res2 = sb.reverse().toString();
            res1 = add(res1, res2);
        }

        return res2;
    }

    /**
     * 两个数字字符串相加 num2 * 10 + num1
     *
     * @param num1 字符串1
     * @param num2 字符串2
     * @return num2 * 10 + num1
     */
    public String add(String num1, String num2) {
        if (num2.equals("0"))
            return num1;

        int len1 = num1.length();
        int len2 = num2.length();
        StringBuffer sb = new StringBuffer();
        sb.append(num1.charAt(len1 - 1));
        int m = 0;
        for (int i = len1 - 2, j = len2 - 1; i >= 0 || j >= 0; i--, j--) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = n1 + n2 + m;
            m = sum / 10;
            sum %= 10;
            sb.append(sum);
        }
        if (m > 0)
            sb.append(m);

        return sb.reverse().toString();
    }


    @Test
    public void testMultiply() {
        String num1 = "123";
        String num2 = "456";
        String res = multiply(num1, num2);
        System.out.println(res);
    }

    @Test
    public void testAdd() {
        String num1 = "123300000000000000000000000000000000000000";
        String num2 = "123";
        String res = add(num1, num2);
        System.out.println(res);
    }
}
