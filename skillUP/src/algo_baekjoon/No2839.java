package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2839 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        int weightSugar = n;

        if (weightSugar==3){
            System.out.println(1);
        }else {
            for (int i = weightSugar / 5; i >= 0; i--) {
                if ((weightSugar - (5 * i)) % 3 == 0) {
                    System.out.println(i + (weightSugar - (5 * i)) / 3);
                    break;
                } else if (i == 0){
                    System.out.println(-1);
                    break;
                }
            }
        }


//        while(n != 0) {
//            if(n % 5 != 0) {
//                if(n - 3 < 0) {
//                    cnt = -1;
//                    break;
//                }
//                cnt++;
//                n -= 3;
//            } else {
//                cnt += (n / 5);
//                n %= 5;
//            }
//        }
//        System.out.println(cnt);
    }
}
