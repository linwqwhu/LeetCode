package com.linwqwhu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 100049.美丽塔II(未完成）
 */
public class Test100049 {
    private List<Integer> maxHeights;

    public long maximumSumOfHeights(List<Integer> maxHeights) {

        int len = maxHeights.size();
        this.maxHeights = maxHeights;
        long ans = 0l;
        for (int i = 0; i < len; i++) {
            ans = Math.max(calcHeight(i), ans);
        }
        return ans;
    }

    private long calcHeight(int index) {
        int len = maxHeights.size();
        int[] height = new int[len];
        height[index] = maxHeights.get(index);
        long sum = height[index] + 0l;
        for (int i = index - 1; i >= 0; i--) {
            height[i] = Math.min(maxHeights.get(i), height[i + 1]);
            sum += height[i];
        }
        for (int i = index + 1; i < len; i++) {
            height[i] = Math.min(maxHeights.get(i), height[i - 1]);
            sum += height[i];
        }
        return sum;
    }

    @Test
    public void testMaximumSumOfHeights() {
        List<Integer> maxHeights = new ArrayList<>();
        maxHeights.add(1000000000);
        maxHeights.add(1000000000);
        maxHeights.add(1000000000);
    }
}
