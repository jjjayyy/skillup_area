package algo_leetcode.easy;

public class Power_of_Two {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-16));
    }

    public static boolean isPowerOfTwo(int n) {

        while(n >= 2) {
            if(n % 2 != 0) {
                return false;
            }
            n /= 2;
        }

        return n <= 0 ? false : true;
    }
}
