package com.linwqwhu;

/**
 * 605.种花问题
 */
public class Test605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for (int i = 0; i < len; ) {
            if (flowerbed[i] == 1) {
                i += 2;
                continue;
            }
            if ((i > 0 && flowerbed[i - 1] != 0) || (i < len - 1 && flowerbed[i + 1] != 0)) {
                i++;
                continue;
            }
            flowerbed[i] = 1;
            n--;
            i += 2;
            if (n <= 0)
                break;
        }
        return n <= 0;
    }
}
