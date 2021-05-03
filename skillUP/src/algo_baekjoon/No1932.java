package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1932 {
    static int n;
    static int[][] numArr;
    static Integer[][] resultArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numArr = new int[n][n];
        resultArr = new Integer[n][n];

        for(int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for(int j = 0; j < temp.length; j++) {
                numArr[i][j] = Integer.parseInt(temp[j]);

                if(i == n-1) {
                    resultArr[i][j] = numArr[i][j];
                }
            }
        }

        System.out.println(dp(0,0));
    }

    static int dp(int depth, int idx) {
        if(depth == n-1) return resultArr[depth][idx];

        if(resultArr[depth][idx] == null) {
            resultArr[depth][idx] = Math.max(dp(depth+1, idx), dp(depth+1, idx+1)) + numArr[depth][idx];
        }
        return resultArr[depth][idx];
    }
}
