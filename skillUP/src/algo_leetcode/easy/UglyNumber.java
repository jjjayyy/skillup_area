package algo_leetcode.easy;

public class UglyNumber {

    public static void main(String[] args) {
        System.out.println(isUgly(0));
    }

    public static boolean isUgly(int n) {
        if(n <= 0) return false;

        for(int i : new int[] {2,3,5}) {
            while(n % i == 0) {
                n /= i;
            }
        }

        return n == 1;

//        if(n == 0) return false;
//
//        int[] nums = {5,3,2};
//
//        boolean isPrime;
//        while(true) {
//            isPrime = false;
//            if(n == 1) {
//                isPrime = true;
//                break;
//            }
//
//            for(int num : nums) {
//                if(n % num == 0) {
//                    n /= num;
//                    isPrime = true;
//                    break;
//                }
//            }
//
//            if(!isPrime) break;
//        }
//        return isPrime;
    }
}
