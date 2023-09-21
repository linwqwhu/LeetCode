package cn;

import org.junit.Test;

/**
 * 寻找两个正序数组中的中位数
 */
public class Test04 {

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int totalCount = 0;
        int medianIndex = (nums1.length + nums2.length) / 2;
        boolean flagTwo = (nums1.length + nums2.length) > 2 * medianIndex ? false : true;
        if (nums1.length == 0) {
            if (flagTwo) {
                return (nums2[medianIndex] + nums2[medianIndex - 1]) / 2.0;
            } else {
                return nums2[medianIndex];
            }
        } else if (nums2.length == 0) {
            if (flagTwo) {
                return (nums1[medianIndex] + nums1[medianIndex - 1]) / 2.0;
            } else {
                return nums1[medianIndex];
            }
        }

        int leftIndex = 0, rightIndex = 0;
        int[] newNums = new int[nums1.length + nums2.length];
        while (leftIndex < nums1.length && rightIndex < nums2.length) {
            if (nums1[leftIndex] <= nums2[rightIndex]) {
                newNums[totalCount] = nums1[leftIndex];
                leftIndex++;
            } else {
                newNums[totalCount] = nums2[rightIndex];
                rightIndex++;
            }
            totalCount++;
            if (totalCount == medianIndex + 1) {
                break;
            }
        }
        while (leftIndex < nums1.length && totalCount <= medianIndex) {
            newNums[totalCount] = nums1[leftIndex];
            leftIndex++;
            totalCount++;
        }
        while (rightIndex < nums2.length && totalCount <= medianIndex) {
            newNums[totalCount] = nums2[rightIndex];
            rightIndex++;
            totalCount++;
        }
        System.out.println(newNums.length);
        if (flagTwo) {
            return (newNums[medianIndex] + newNums[medianIndex - 1]) / 2.0;
        } else {
            return newNums[medianIndex];
        }
    }

    @Test
    public void t() {
        int[] nums1 = {};
        int[] nums2 = {2, 3};
        System.out.println(nums1.length);
        System.out.println(nums2.length);
        double n = findMedianSortedArrays(nums1, nums2);
        System.out.println(n);
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int totalCount = (nums1Length + nums2Length);
        int left = -1, right = -1;
        int nums1Index = 0, nums2Index = 0;
        for (int i = 0; i <= totalCount / 2; i++) {
            left = right;
            if (nums1Index < nums1Length && (nums2Index >= nums2Length || nums1[nums1Index] < nums2[nums2Index])) {
                right = nums1[nums1Index++];
            } else {
                right = nums2[nums2Index++];
            }
        }
        if ((totalCount & 1) == 0) {
            return (left + right) / 2.0;
        } else
            return right;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        //数组从索引0开始，因此在此必须+1 ,索引(k+1)的数，才是第k个数。
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {

        int len1 = end1 + 1 - start1;//nums1中剩余的个数（未剔除的个数）
        int len2 = end2 + 1 - start2;//nums2中剩余的个数

        //保证 len1 永远比 len2 小
        if (len1 > len2)
            return getKth(nums2, start2, end2, nums1, start1, end1, k);//互换位置而已
        if (len1 == 0)
            return nums2[start2 + k - 1];
        if (k == 1)
            return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
