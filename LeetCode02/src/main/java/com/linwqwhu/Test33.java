package com.linwqwhu;

/**
 * 33.搜索旋转排序数组
 */
public class Test33 {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return -1;
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid])
                    right = mid - 1;
                else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[len - 1])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
