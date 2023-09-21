package com.linwqwhu;

import java.util.Arrays;

/**
 * 1921. 消灭怪物的最大数量
 */
public class Test1921 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        //根据距离和速度计算出时间
        //至少某一时刻有两个相同的值
        int n = dist.length;
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
//            times[i] = (dist[i] - 1)/speed[i] +1;
            times[i] = (int) Math.ceil(dist[i] * 1.0 / speed[i]);
        }
        Arrays.sort(times);
        for (int i = 0; i < n; i++) {
            //对于第 i 个怪物，如果 times[i] > i，说明第 i 个怪物可以被消灭，否则说明第 i 个怪物无法被消灭，直接返回 i 即可
            if (times[i] <= i) {
                return i;
            }
        }
        return times.length;

    }
}
