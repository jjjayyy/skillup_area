package algo_leetcode;

public class Remove_Duplicate_Nums {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        removeDuplicates(nums);
    }

    public static int removeDuplicates(int[] nums) {
        int[] expectedNums = nums;
        int answer = 0;
        int prevNum = 101;

        for(int num : expectedNums) {
            if(prevNum != num) {
                nums[answer] = num;
                answer++;
            }
            prevNum = num;
        }

        return answer;
    }
}
