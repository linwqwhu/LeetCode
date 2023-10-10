package com.linwqwhu;

import org.junit.Test;

import javax.xml.bind.annotation.XmlAnyAttribute;
import java.util.Map;

/**
 * 100088. 有序三元组中的最大值 I
 */
public class Test100088 {
    public long maximumTripletValue(int[] nums) {
        long res = 0l;
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    res = Math.max(res, (nums[i] * 1l - nums[j] * 1l) * 1l * nums[k]);
                }
            }
        }
        return res;
    }

    @Test
    public void testMaximumTripletValue() {
//        int[] nums = {12, 6, 1, 2, 7};
        int[] nums = {1000000, 1, 1000000}; //999999000000
        long res = maximumTripletValue(nums);
        System.out.println(res);

    }
}
