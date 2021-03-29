package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No11047 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] strArr = str.split(" ");
        int n = Integer.parseInt(strArr[0]);
        int k = Integer.parseInt(strArr[1]);

        int[] moneyType = new int[n];
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            moneyType[i] = Integer.parseInt(br.readLine());
        }

        for(int i = n-1; i >= 0; i--) {
            if(k >= moneyType[i]) {
                cnt += (k / moneyType[i]);
                k %= moneyType[i];
            }
            if(k == 0) {
                break;
            }
        }
        System.out.println(cnt);
    }
}
