package com.linwqwhu;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;

/**
 * 2594. 修车的最少时间
 */
public class Test2594 {
    public long repairCars(int[] ranks, int cars) {
        long start = 1;
        Arrays.sort(ranks);
        long end = 1l * cars * cars * ranks[0];
//        long end = 1l * cars * cars * Arrays.stream(ranks).min().getAsInt();//找到最小值需要时间较长

        while (start < end) {
//            long mid = (start + end) / 2;
            long mid = (start + end) >> 1; //使用位运算更快
            long count = 0;
            for (int r : ranks) {
                count += (long) Math.sqrt(mid / r);
                if (count >= cars)
                    break;
            }
            if (count >= cars)
                end = mid;
            else
                start = mid + 1;
        }
        return end;
    }

    @Test
    public void testRepairCars() {

        int[] ranks = {31, 31, 5, 19, 19, 10, 31, 18, 19, 3, 16, 20, 4, 16, 2, 25,
                10, 16, 23, 18, 21, 23, 28, 6, 7, 29, 11, 11, 19, 20, 24, 19, 26,
                12, 29, 29, 1, 14, 17, 26, 24, 7, 11, 28, 22, 14, 31, 12, 3, 19, 16, 26, 11};

        int cars = 736185;

        System.out.println(repairCars(ranks, cars));

    }
}
