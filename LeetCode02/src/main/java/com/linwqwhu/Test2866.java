package com.linwqwhu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 2866、100049.美丽塔II(未完成）
 */
public class Test2866 {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int len = maxHeights.size();
        //suf[i]表示以maxHeight[i]为节点的右侧递减数组高度和（含i）
        long[] suf = new long[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            int j = i + 1;
            //在i的右侧找到一个距离i最近且满足maxHeights[i] > maxHeights[j]的点j
            while (j < len && maxHeights.get(i) <= maxHeights.get(j)) {
                j++;
            }
            suf[i] = maxHeights.get(i) * (j - i) + suf[j];
        }

        //pre[i]表示以maxHeight[i]为节点的左侧递减数组高度和（不含i）
        long[] pre = new long[len + 1];
        long res = 0l;
        for (int i = 0; i < len; i++) {
            int j = i - 1;
            //在i的左侧找到一个距离i最近且满足maxHeights[i] > maxHeights[j]的点j
            while (j >= 0 && maxHeights.get(i) <= maxHeights.get(j)) {
                j--;
            }
            pre[i + 1] = maxHeights.get(i) * (i - j) + pre[j + 1];
            res = Math.max(res, suf[i] + pre[i]);
        }
        res = Math.max(res, suf[len] + pre[len]);
        return res;
    }

    @Test
    public void testMaximumSumOfHeights() {
        List<Integer> maxHeights = new ArrayList<>();
        maxHeights.add(1000000000);
        maxHeights.add(1000000000);
        maxHeights.add(1000000000);
    }
}
