package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No9461 {
    static long[] dp = new long[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < 101; i++) {
            dp[i] = -1;
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            stringBuilder.append(findPn(N-1)).append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    static long findPn(int N) {
        if(dp[N] != -1) {
            return dp[N];
        }

        if(N-5 >= 0) {
            dp[N] = findPn(N-1) + findPn(N-5);
        }
        return dp[N];
    }
}
