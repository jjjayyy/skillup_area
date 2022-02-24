package algo_leetcode.easy;

public class Climb_Stairs {

    public static void main(String[] args) {
        climbStairs(2);
    }

    public static int climbStairs(int n) {

        int a = 0, b = 1;
        int sum = a + b;

        for (int i = 0; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }

        return sum;
    }
}
