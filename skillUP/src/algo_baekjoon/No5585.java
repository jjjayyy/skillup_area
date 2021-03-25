package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No5585 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());
        int money = 1000 - price;
        int cnt = 0;

        int[] changeArr = {500, 100, 50, 10, 5, 1};

        for(int change : changeArr) {
            if(money >= change) {
                cnt += (money / change);
                money %= change;
            }
        }
        System.out.println(cnt);
    }
}
