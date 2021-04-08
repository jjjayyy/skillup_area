package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int firstTemp = 0;
        int secondTemp = 1;

        for(int i = 0; i < n; i++) {
            int
            fibonacci(firstTemp,secondTemp);
        }



    }

    static int fibonacci(int first, int second) {
        return first + second;
    }
}
