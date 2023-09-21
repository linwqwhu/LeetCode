package com.linwqwhu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * 658.找到K个最接近的元素
 */
public class Test658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (arr[mid] <= x)
                left = mid;
            else
                right = mid - 1;
        }
        right = (right + 1 < arr.length && Math.abs(arr[right + 1] - x) < Math.abs(arr[right] - x)) ? right + 1 : right;
        int i = right - 1;
        int j = right + 1;
        while (j - i - 1 < k) {
            if (i >= 0 && j < arr.length) {
                if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x))
                    i--;
                else j++;
            } else if (i < 0)
                j++;
            else i--;
        }
        List<Integer> res = new ArrayList<>();
        for (i = i + 1; i < j; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    @Test
    public void testFindClosestElements() {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = -1;
        List<Integer> li = findClosestElements(arr, k, x);
        System.out.println(li.toString());

    }
}
