package algo_leetcode;

import java.util.HashMap;
import java.util.Map;

public class Single_Number {

    public static void main(String[] args) {
        int[] nums = {2,1,2};
        singleNumber(nums);
    }

    public static int singleNumber(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int number = 0;
        for(int key : map.keySet()) {
            if(map.get(key) == 1) {
                number = key;
                break;
            }
        }

        System.out.println(number);
        return number;
    }
}
