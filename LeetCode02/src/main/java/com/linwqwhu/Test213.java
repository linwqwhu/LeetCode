package com.linwqwhu;

/**
 * 213.打家劫舍II
 */
public class Test213 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[][][] dp = new int[len][2][2];
        dp[0][0][0] = 0;
        dp[0][1][0] = 0;
        dp[0][0][1] = 0;
        dp[0][1][1] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1]);
            dp[i][0][1] = dp[i - 1][0][0] + nums[i];
            dp[i][1][1] = dp[i - 1][1][0] + nums[i];
        }
        return Math.max(Math.max(dp[len - 1][0][1], dp[len - 1][0][0]), dp[len - 1][1][0]);
    }

    /**
     * 对上面方法的优化
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[0][1] = 0;
        dp[1][1] = nums[0];
        for (int i = 1; i < len; i++) {
            int[][] dpNew = new int[2][2];
            dpNew[0][0] = Math.max(dp[0][0], dp[0][1]);
            dpNew[1][0] = Math.max(dp[1][0], dp[1][1]);
            dpNew[0][1] = dp[0][0] + nums[i];
            dpNew[1][1] = dp[1][0] + nums[i];
            dp = dpNew;
        }
        return Math.max(Math.max(dp[0][1], dp[0][0]), dp[1][0]);
    }
}
