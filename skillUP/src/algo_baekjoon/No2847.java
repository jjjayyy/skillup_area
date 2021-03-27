package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2847 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] scoreArr = new int[n];
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            scoreArr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = n-2; i >= 0; i--) {
            if(scoreArr[i+1] <= scoreArr[i]) {
                cnt += scoreArr[i] - scoreArr[i+1] + 1;
                scoreArr[i] = scoreArr[i+1] - 1;
            }
        }

        System.out.println(cnt);
    }
}
