package com.linwqwhu;

import org.junit.Test;

/**
 * 165.比较版本号
 */
public class Test165 {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int[] vInt1 = new int[v1.length];
        int[] vInt2 = new int[v2.length];
        for (int i = 0; i < vInt1.length; i++) {
            vInt1[i] = Integer.valueOf(v1[i]);
        }
        for (int i = 0; i < vInt2.length; i++) {
            vInt2[i] = Integer.valueOf(v2[i]);
        }

        int k = 0;
        for (k = 0; k < vInt2.length && k < vInt1.length; k++) {
            if (vInt1[k] < vInt2[k])
                return -1;
            if (vInt1[k] > vInt2[k])
                return 1;
        }
        while (k < vInt1.length) {
            if (vInt1[k] != 0) {
                return 1;
            }
            k++;
        }
        while (k < vInt2.length) {
            if (vInt2[k] != 0) {
                return -1;
            }
            k++;
        }
        return 0;
    }

    @Test
    public void testCompareVersion() {
        String version1 = "1";
        String version2 = "0";
        compareVersion(version1, version2);
    }

    public int compareVersion2(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length || i < v2.length; i++) {
            int x = 0;
            int y = 0;
            if (i < v1.length)
                x = Integer.valueOf(v1[i]);
            if (i < v2.length)
                y = Integer.valueOf(v2[i]);
            if (x > y)
                return 1;
            if (x < y)
                return -1;
        }
        return 0;
    }

    public int compareVersion3(String version1, String version2) {

        int m = version1.length();
        int n = version2.length();
        for (int i = 0, j = 0; i < m || j < n; ) {
            int x = 0;
            int y = 0;
            while (i < m && version1.charAt(i) != '.') {
                x = x * 10 + (version1.charAt(i) - '0');
                i++;
            }
            i++;//跳过.号
            while (j < n && version2.charAt(j) != '.') {
                y = y * 10 + (version2.charAt(j) - '0');
                j++;
            }
            j++;

            if (x > y)
                return 1;
            if (x < y)
                return -1;
        }

        return 0;
    }


}
