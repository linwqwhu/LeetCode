package cn;

import org.junit.Test;

/**
 * 整数反转
 */
public class Test07 {
    public int reverse1(int x) {
        if (x == 0) {
            return 0;
        }
        String str = String.valueOf(x);
        char ch = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        String reverse;
        boolean flag = true;
        if (ch == '-') {
            reverse = sb.append(str.substring(1)).reverse().toString();
            flag = false;
        } else {
            reverse = sb.append(str).reverse().toString();
        }

        try {
            int num = Integer.parseInt(reverse);
            return flag ? num : -num;
        } catch (Exception e) {
            return 0;
        }
    }

    public int reverse(int x) {
        if (x > -10 && x < 10) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Math.abs(x));
        try {
            int num = Integer.parseInt(sb.reverse().toString());
            return x > 0 ? num : -num;
        } catch (Exception e) {
            return 0;
        }
    }

    @Test
    public void t() {
        int x = -120;
        System.out.println(reverse(x));
    }

}
