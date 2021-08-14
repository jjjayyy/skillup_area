package CodingTest;

public class TOSS_Test6 {

    static int cnt = 0;
    public static void main(String[] args) {
        dfs(70);
        System.out.println(cnt);
    }

    public static long solution(int numOfStairs) {
        long answer = 0;
        dfs(numOfStairs);
        return cnt;
    }

    private static void dfs(int num) {
        if(num <= 0) {
            return;
        }

        for(int i = 1; i <= 3; i++) {
            if(num - i >= 0) {
                num -= i;
                cnt++;
                dfs(num);
            }
        }
    }
}
