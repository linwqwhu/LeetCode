package com.linwqwhu;

/**
 * 42.接雨水
 */
public class Test42 {
    public int trap(int[] height) {
        int len = height.length;
        int[] preMax = new int[len];
        preMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            preMax[i] = Math.max(preMax[i - 1], height[i]);
        }

        int[] sufMax = new int[len];
        sufMax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            sufMax[i] = Math.max(sufMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += Math.min(preMax[i], sufMax[i]) - height[i];
        }
        return ans;
    }

    public int trap2(int[] height) {
        int len = height.length;
        int ans = 0;
        int preMax = height[0], sufMax = height[len - 1];
        int left = 0, right = len - 1;
        while (left <= right) {
            if (preMax > sufMax) {
                sufMax = Math.max(sufMax, height[right]);
                ans += sufMax - height[right];
                right--;
            } else {
                preMax = Math.max(preMax, height[left]);
                ans += preMax - height[left];
                left++;
            }
        }
        return ans;
    }
}
