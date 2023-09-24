package com.linwqwhu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 100048.美丽塔I
 */
public class Test100048 {

    public long maximumSumOfHeights(List<Integer> maxHeights) {

        int len = maxHeights.size();
        int max = Collections.max(maxHeights);
        int min = Collections.min(maxHeights);
        int mid = min + (max - min) / 2;

        List<Integer> indexs = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (maxHeights.get(i) >= mid)
                indexs.add(i);
        }

        long ans = 0l;
        for (int i = 0; i < indexs.size(); i++) {
            ans = Math.max(calcHeight(maxHeights, indexs.get(i)), ans);
        }
        return ans;
    }

    private long calcHeight(List<Integer> maxHeights, int index) {
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
    }
}
