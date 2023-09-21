package cn;

import org.junit.Test;

import java.util.Arrays;

/**
 * 删除某些元素后的数组均值
 */
public class Test1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        double average = 0;
        int minIndex = (int) (len * 0.05);
        int maxIndex = (int) (len * 0.95);
        for (int i = minIndex; i < maxIndex; i++) {
            average = (average * (i - minIndex) + arr[i]) / (i - minIndex + 1);
        }
        return average;
    }

    public double trimMean1(int[] arr) {

        Arrays.sort(arr);
        long average = 0;
        int minIndex = (int) (arr.length * 0.05);
        for (int i = minIndex; i < arr.length - minIndex; i++) {
            average = average + arr[i];
        }
        return average * 1.0 / (arr.length - 2 * minIndex);

    }

    @Test
    public void t() {
        //int[] arr = {4,8,4,10,0,7,1,3,7,8,8,3,4,1,6,2,1,1,8,0,9,8,0,3,9,10,3,10,1,10,7,3,2,1,4,9,10,7,6,4,0,8,5,1,2,1,6,2,5,0,7,10,9,10,3,7,10,5,8,5,7,6,7,6,10,9,5,10,5,5,7,2,10,7,7,8,2,0,1,1};
        int[] arr = {9, 7, 8, 7, 7, 8, 4, 4, 6, 8, 8, 7, 6, 8, 8, 9, 2, 6, 0, 0, 1, 10, 8, 6, 3, 3, 5, 1, 10, 9, 0, 7, 10, 0, 10, 4, 1, 10, 6, 9, 3, 6, 0, 0, 2, 7, 0, 6, 7, 2, 9, 7, 7, 3, 0, 1, 6, 1, 10, 3};
        System.out.println(trimMean1(arr));
    }


}
