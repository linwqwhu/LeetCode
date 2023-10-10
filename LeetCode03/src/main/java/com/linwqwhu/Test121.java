package com.linwqwhu;

/**
 * 121.买卖股票的最佳时机
 */
public class Test121 {
    /**
     * 超时
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }


    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int profit = 0;
        int cost = prices[0];

        return 0;
    }
}
