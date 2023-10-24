package com.linwqwhu;

/**
 * 11.盛最多水的容器
 */
public class Test11 {
    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        int ans = 0;
        while (left < right) {
            ans = Math.max(ans, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return ans;
    }
}
