package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1904 {
    static int N;
    static int[] dp = new int[1000001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            dp[i] = -1;
        }

        dp[0] = 1;
        dp[1] = 2;

        System.out.println(dfs(N-1));
    }

    static int dfs(int depth) {
        if(dp[depth] == -1) {
            dp[depth] = (dfs(depth-1) + dfs(depth-2)) % 15746;
        }
        return dp[depth];
    }
}
