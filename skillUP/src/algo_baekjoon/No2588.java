package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2588 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        int temp = num2;

        while(temp != 0) {
            System.out.println(num1 * (temp % 10));
            temp /= 10;
        }
        System.out.println(num1 * num2);
    }
}
