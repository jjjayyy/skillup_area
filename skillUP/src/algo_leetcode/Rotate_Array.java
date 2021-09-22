package algo_leetcode;

public class Rotate_Array {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        for(int num : nums) {
            System.out.println(num);
        }
    }

    public static void rotate(int[] nums, int k) {
        int[] temp = nums.clone();
        for(int i = 0; i < nums.length; i++) {
            temp[(i+k) % nums.length] = nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }

//        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
//
//        for(int i = 0; i < k; i++) {
//            numsList.add(0,numsList.get(numsList.size()-1));
//            numsList.remove(numsList.size()-1);
//        }
//
//        for(int i = 0; i < nums.length; i++) {
//            nums[i] = numsList.get(i);
//        }
    }
}
