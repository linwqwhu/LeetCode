package com.linwqwhu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2530.执行K次操作后的最大分数
 */
public class Test2530 {
    public long maxKelements(int[] nums, int k) {
        int len = nums.length;
        long res = 0l;
        while (k > 0) {
            k--;
            int index = 0;
            for (int i = 1; i < len; i++) {
                if (nums[index] < nums[i]) {
                    index = i;
                }
            }
            res += nums[index];
            nums[index] = (int) Math.ceil(nums[index] * 1.0 / 3);
        }
        return res;
    }

    public long maxKelements2(int[] nums, int k) {
        long res = 0l;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        while (k > 0) {
            k--;
            int num = queue.poll();
            res += num;
            queue.offer((int) Math.ceil(num * 1.0 / 3));
        }
        return res;
    }
}
