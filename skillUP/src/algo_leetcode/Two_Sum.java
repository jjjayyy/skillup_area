package algo_leetcode;

public class Two_Sum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(target == nums[i] + nums[j]) {
                    System.out.println(i);
                    System.out.println(j);
                }
            }
        }
    }

}
