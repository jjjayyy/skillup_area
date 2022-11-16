package algo_leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Summary_Ranges {
    public static void main(String[] args) {
//        int[] nums = {0,1,2,4,5,7};
//        int[] nums = {0,2,3,4,6,8,9};
//        int[] nums = {-1};
        int[] nums = {0,1,2};
        summaryRanges(nums);
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> summaryList = new ArrayList<>();

        if(nums.length == 1) {
            summaryList.add(String.valueOf(nums[0]));
            return summaryList;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < nums.length; i++) {

            if(i > 0 && nums[i-1]+1 != nums[i]) {   //마지막 추가 위해서
                if(stringBuilder.length() > 0 && Integer.parseInt(stringBuilder.toString()) != nums[i-1]) {
                    stringBuilder.append("->");
                    stringBuilder.append(nums[i-1]);
                }
                summaryList.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }

            if(stringBuilder.length() == 0) {
                stringBuilder.append(nums[i]);
            }

            if(i == nums.length-1) {
                if(Integer.parseInt(stringBuilder.toString()) != nums[i]) {
                    stringBuilder.append("->");
                    stringBuilder.append(nums[i]);
                }
                summaryList.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }
        return summaryList;
    }
}
