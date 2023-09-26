package com.linwqwhu;

/**
 * 2582.递枕头
 */
public class Test2582 {
    public int passThePillow(int n, int time) {
        int c = time / (n - 1);
        if (c % 2 == 0) {
            return 1 + time % (n - 1);
        } else {
            return n - time % (n - 1);
        }
    }

    public int passThePillow2(int n, int time) {
        time %= (n - 1) * 2;
        return time > n ? n * 2 - time - 1 : time + 1;
    }
}
