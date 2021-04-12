package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 1;

        for(int i = n; i > 0; i--) {
            answer *= i;
        }
        System.out.println(answer);
    }
}
