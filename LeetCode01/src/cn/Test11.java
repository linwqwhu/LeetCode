package cn;

import org.junit.Test;

/**
 * 盛最多水的容器
 */
public class Test11 {
    /**
     * 暴力破解
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min( height[j],height[i]) * (j - i);
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }

    @Test
    public void t() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        //int[] height = {1, 1};
        System.out.println(maxArea(height));
    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;
        while (i < j) {
            max = height[i] < height[j] ? Math.max(max, (j - i) * height[i++]) : Math.max(max, (j - i) * height[j--]);
        }
        return max;
    }
}
