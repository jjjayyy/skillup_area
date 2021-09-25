package algo_leetcode;

import java.util.Arrays;

public class Contains_Duplicate {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        long distinctCnt = Arrays.stream(nums).distinct().count();
        long length = nums.length;

        return distinctCnt != length;
    }

}
