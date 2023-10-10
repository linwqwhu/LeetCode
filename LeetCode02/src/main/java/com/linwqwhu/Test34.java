package com.linwqwhu;

import javax.sound.midi.MidiChannel;
import java.beans.beancontext.BeanContext;

/**
 * 34.在排序数组中查找元素的第一个和最后一个位置
 */
public class Test34 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return new int[]{-1, -1};

        int start = -1;
        int end = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                start = i;
                end = i + 1;
                while (end < len && nums[end] == target) {
                    end++;
                }
                break;
            }
        }
        end = start == -1 ? -1 : end - 1;
        return new int[]{start, end};
    }

    public int[] searchRange2(int[] nums, int target) {
        int len = nums.length;

        if (len == 0)
            return new int[]{-1, -1};
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                int start = mid - 1;
                while (start >= 0 && nums[start] == target)
                    start--;
                int end = mid + 1;
                while (end < len && nums[end] == target) {
                    end++;
                }
                return new int[]{start + 1, end - 1};
            } else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return new int[]{-1, -1};
    }
}
