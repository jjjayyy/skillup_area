package algo_leetcode.easy;

public class Search_Insert_Position {
    public static void main(String[] args) {
        int[] nums = {1,2,4,6,7};
        System.out.println(searchInsert(nums, 3));
    }

    public static int searchInsert(int[] nums, int target) {

        int i = 0;
        int j = nums.length - 1;
        while(i <= j) {
            int mid = (i+j)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i;

//        int centerIdx = (nums.length-1) / 2;
//        int lastIdx = nums.length - 1;
//        if(nums[nums.length-1] < target) {
//            return nums.length;
//        }
//
//        if(nums[0] > target) {
//            return 0;
//        }
//
//        while (centerIdx != 0) {
//            if(nums[centerIdx] == target) {
//                return centerIdx;
//            } else {
//                if(nums[centerIdx] < target) {
//                    int tempIdx = (lastIdx - centerIdx) / 2;
//                    if(tempIdx == 0) {
//                        break;
//                    }
//                    centerIdx += tempIdx;
//                } else {
//                    lastIdx = centerIdx;
//                    centerIdx /= 2;
//                }
//            }
//        }

//        return centerIdx+1;
    }
}
