package cn;

import java.util.HashMap;

/**
 * 两数之和
 */
public class Test01 {

    /**
     * 暴力算法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int low = 0, high = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            int first = nums[i];
            boolean flag = false;
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] == target - first) {
                    flag = true;
                    low=i;
                    high=j;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        int[] index = new int[2];
        index[0] = low;
        index[1] = high;
        return index;
    }

    /**
     * 哈希映射
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
