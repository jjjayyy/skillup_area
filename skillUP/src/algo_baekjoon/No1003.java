package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1003 {
    static Integer[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder builder = new StringBuilder();
        dp = new Integer[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i = 0; i < T; i++) {
            int temp = Integer.parseInt(br.readLine());
            fibonacci(temp);
            builder.append(dp[temp][0]).append(" ")
                    .append(dp[temp][1]).append("\n");
        }
        System.out.println(builder.toString());
    }
    //commit
    static Integer[] fibonacci(int n) {
        if(dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] = fibonacci(n-1)[0]+fibonacci(n-2)[0];
            dp[n][1] = fibonacci(n-1)[1]+fibonacci(n-2)[1];
        }
        return dp[n];
    }
}
