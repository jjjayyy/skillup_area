package algo_leetcode;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
    //commit test
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                result[0] = map.get(target-nums[i]);
                result[1] = i;
            }
            map.put(nums[i], i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        System.out.println(twoSum(nums, target)[1]);

    }

}
