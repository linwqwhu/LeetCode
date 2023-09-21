package com.linwqwhu;

import java.util.HashSet;
import java.util.Set;

/**
 * 202.快乐数
 */
public class Test202 {
    public boolean isHappy(int n) {
        while (n >= 10) {
            n = calcSquare(n);
        }

        boolean[] res = {false, true, false, false, false, false, false, true, false, false, true};
        return res[n];
    }

    public int calcSquare(int n) {
        int num = 0;
        while (n > 0) {
            num += Math.pow(n % 10, 2);
            n /= 10;
        }
        return num;
    }

    public boolean isHappy2(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = calcSquare(n);
        }
        return n == 1;
    }

    public boolean isHappy3(int n) {
        int slowRunner = n;
        int fastRunner = calcSquare(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = calcSquare(slowRunner);
            fastRunner = calcSquare(calcSquare(fastRunner));
        }
        return fastRunner == 1;
    }
}
