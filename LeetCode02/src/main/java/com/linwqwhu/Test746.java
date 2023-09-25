package com.linwqwhu;

/**
 * 756.使用最小花费爬楼梯
 */
public class Test746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        dp[n - 1] = cost[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int z = 0;
        int y = cost[n - 1];
        int x = 0;
        for (int i = n - 2; i >= 0; i--) {
            x = cost[i] + Math.min(y, z);
            z = y;
            y = x;
        }
        return Math.min(x, y);
    }
}
