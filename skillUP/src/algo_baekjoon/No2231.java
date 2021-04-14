package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2231 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nStr = br.readLine();
        int N = Integer.parseInt(nStr);

        int startNum = N - (nStr.length() * 9);
        int result = 0;

        for(int i = startNum; i < N; i++) {
            int sum = 0;
            int temp = i;

            while(temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if(sum+i == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
