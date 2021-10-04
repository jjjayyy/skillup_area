package algo_leetcode;

public class Move_Zeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int s = 0, f = 0;
        while (f < nums.length) {
            if (nums[f] == 0) {
                f++;
                continue;
            }
            swap(nums, s, f);
            s++;
            f++;
        }

//        for(int i = 0; i < nums.length; i++) {
//            if(nums[i] == 0) {
//                for(int j = i+1; j < nums.length; j++) {
//                    if(nums[j] == 0) {
//                        continue;
//                    }
//                    int temp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = temp;
//                    break;
//                }
//            }
//        }
//
//        for(int num : nums) {
//            System.out.println(num);
//        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
