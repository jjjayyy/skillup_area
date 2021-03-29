package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No13305 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        String distance = br.readLine();
        String pay = br.readLine();

        String[] distArr = distance.split(" ");
        String[] payArr = pay.split(" ");

        long payTemp = Long.MAX_VALUE;
        long result = 0;

        for(int i = 0; i < distArr.length; i++) {
            long dist = Long.parseLong(distArr[i]);
            long payNum = Long.parseLong(payArr[i]);

            if(payTemp > payNum) {
                payTemp = payNum;
            }
            result += (payTemp * dist);
        }
        System.out.println(result);
    }
}
