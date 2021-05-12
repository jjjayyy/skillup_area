package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No9184 {
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = "";

        List<int[]> numList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        while(!temp.equals("-1 -1 -1")) {
            int[] numArr = new int[3];
            temp = br.readLine();
            if(temp.equals("-1 -1 -1")) {
                break;
            }
            String[] tempArr = temp.split(" ");

            for(int i = 0; i < tempArr.length; i++) {
                numArr[i] = Integer.parseInt(tempArr[i]);
            }
            numList.add(numArr);
        }

        for(int[] item : numList) {
            int a = item[0];
            int b = item[1];
            int c = item[2];

            builder.append("w(" + a + ", " + b + ", " + c + ") = ");
            builder.append(w(a, b, c));
            builder.append("\n");
        }

        System.out.println(builder.toString());
    }

    static int w(int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if(a > 20 || b > 20 || c > 20) {
            dp[20][20][20] = w(20, 20, 20);
            return dp[20][20][20];
        }

        if(dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if(a < b && b < c) {
            dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            return dp[a][b][c];
        }
        dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        return dp[a][b][c];
    }
}
