package com.linwqwhu;

/**
 * 198.打家劫舍
 * 动态规划
 */
public class Test198 {

    public int rob(int[] nums) {
        int len = nums.length;
        //dp[i][0]:不进入第i-1家的最高金额（从0开始）
        //dp[i][1]:进入第i-1家的最高金额
        int[][] dp = new int[len + 1][2];
        dp[0][0] = 0;//边界
        dp[0][1] = 0;
        for (int i = 1; i <= len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
        }
        return Math.max(dp[len][0], dp[len][1]);
    }

    public int rob2(int[] nums) {
        int len = nums.length;
        //dp[i][0]:不进入第i-1家的最高金额（从0开始）
        //dp[i][1]:进入第i-1家的最高金额
        int[] dp = new int[2];
        for (int i = 1; i <= len; i++) {
            int[] dpNew = new int[2];
            dpNew[0] = Math.max(dp[0], dp[1]);
            dpNew[1] = dp[0] + nums[i - 1];
            dp = dpNew;
        }
        return Math.max(dp[0], dp[1]);
    }
}
