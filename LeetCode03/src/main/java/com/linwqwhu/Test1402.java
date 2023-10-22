package com.linwqwhu;

import org.junit.Test;

import java.util.Arrays;

/**
 * 1402.做菜顺序
 */
public class Test1402 {
    public int maxSatisfaction(int[] satisfaction) {

        int likeTime = 0;
        Arrays.sort(satisfaction);
        int len = satisfaction.length;
        if (satisfaction[len - 1] <= 0)
            likeTime = 0;
        else if (satisfaction[0] >= 0) {
            for (int i = 0; i < len; i++) {
                likeTime += (i + 1) * satisfaction[i];
            }
        } else {
            int sum = 0;
            for (int i = len - 1; i >= 0; i--) {
                int num = sum + satisfaction[i];
                if (num >= 0) {
                    sum = num;
                    likeTime += sum;
                }
            }
        }
        return likeTime;
    }

    @Test
    public void testMaxSatisfaction() {
//        int[] satisfaction = {0, -1, -9, -8, 5};
        int[] satisfaction = {-2, 5, -1, 0, 3, -3};
        int res = maxSatisfaction(satisfaction);
        System.out.println(res);
    }
}
