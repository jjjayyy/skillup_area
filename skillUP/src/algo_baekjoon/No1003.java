package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1003 {
    static int zeroCnt = 0;
    static int oneCnt = 0;
    static String[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] caseArr = new int[T];
        int maxCase = Integer.MIN_VALUE;

        StringBuilder builder = new StringBuilder();


        for(int i = 0; i < T; i++) {
            caseArr[i] = Integer.parseInt(br.readLine());
            maxCase = Math.max(maxCase, caseArr[i]);
        }
        dp = new String[maxCase];
        fibonacci(maxCase);



        zeroCnt = 0;
        oneCnt = 0;

        int testCase = Integer.parseInt(br.readLine());
        fibonacci(testCase);
        builder.append(zeroCnt)
                .append(" ")
                .append(oneCnt)
                .append("\n");
        System.out.println(builder.toString());
    }

    static int fibonacci(int n) {
        if(n == 0) {
            zeroCnt++;
            return 0;
        } else if (n == 1) {
            oneCnt++;
            return 1;
        } else {
            int result = fibonacci(n-1) + fibonacci(n-2);
            dp[n] =
            return result
        }
    }
}
