package cn;

import org.junit.Test;

/**
 * 删除有序数组中的重复项
 */
public class Test26 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                if (j - i > 0) {
                    nums[i] = nums[j];
                }
            }
        }
        return i + 1;
    }

    @Test
    public void t() {

    }
}
