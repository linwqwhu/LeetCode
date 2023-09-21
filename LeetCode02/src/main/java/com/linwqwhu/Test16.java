package com.linwqwhu;

import org.junit.Test;

import java.lang.reflect.WildcardType;
import java.util.Arrays;

/**
 * 16.最接近的三数之和
 */
public class Test16 {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    res = Math.abs(res - target) > Math.abs(nums[i] + nums[j] + nums[k] - target) ? nums[i] + nums[j] + nums[k] : res;
                }
            }
        }
        return res;
    }

    @Test
    public void testThreeSumClosest() {
        int[] nums = {-100, -98, -2, -1};
        int target = -101;
        threeSumClosest(nums, target);
    }

    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int minDiff = Integer.MAX_VALUE;
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int s = nums[i] + nums[i + 1] + nums[i + 2];
            if (s > target) {//后面无论怎么选，选出的三个数的和不会比 s 还小
                if (s - target < minDiff)
                    res = s;// 由于下面直接 break，这里无需更新 minDiff
                break;
            }

            s = nums[i] + nums[len - 2] + nums[len - 1];
            if (s < target) {//后面无论怎么选，选出的三个数的和不会比 s 还大
                if (target - s < minDiff) {
                    minDiff = target - s;
                    res = s;
                }
                continue;
            }

            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                s = nums[i] + nums[j] + nums[k];
                if (s == target)
                    return target;
                else if (s > target) {
                    if (s - target < minDiff) {
                        minDiff = s - target;
                        res = s;
                    }
                    k--;
                } else {
                    if (target - s < minDiff) {
                        minDiff = target - s;
                        res = s;
                    }
                    j++;
                }
            }
        }
        return res;
    }

}
