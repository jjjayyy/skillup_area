package algo_leetcode;

public class Maximum_Subarray {
    public static void main(String[] args) {
        int[] nums = {-1};
        maxSubArray(nums);
    }

    public static int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = 0;

        for(int  i = 0; i < nums.length; i++) {
            if(i == 0) {
                maxSum = nums[i];
            }

            currSum = Math.max(nums[i] + currSum, nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        System.out.println(maxSum);
            return maxSum;
    }
}
