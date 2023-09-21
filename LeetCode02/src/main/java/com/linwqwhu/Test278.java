package com.linwqwhu;

import org.junit.Test;

import java.time.chrono.MinguoChronology;

/**
 * 278.第一个错误的版本
 */
public class Test278 {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid))
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }

    private boolean isBadVersion(int version) {
        return version >= 4;
    }

    @Test
    public void testFirstBadVersion() {
        int badVersion = firstBadVersion(5);
        System.out.println(badVersion);
    }
}
