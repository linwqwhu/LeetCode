package cn;

/**
 * 合并两个有序的数组
 */
public class Test88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }
        while (i < m) {
            res[k++] = nums1[i++];
        }
        while ((j < n)) {
            res[k++] = nums2[j++];
        }
        for (k = 0; k < m + n; k++) {
            nums1[k] = res[k];
        }
    }


}
