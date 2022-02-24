package algo_leetcode.easy;

import java.util.Arrays;

public class Merge_Sorted_Array {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if(nums2.length > 0) {
            int index = 0;
            for(int i = m; i < nums1.length; i++) {
                nums1[i] = nums2[index];
                index++;
            }
        }

        Arrays.sort(nums1);

    }
}
