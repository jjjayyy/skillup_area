package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(0,1, 2, 20));
    }

    static int fibonacci(int first, int second, int cnt, int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        if(n == cnt) {
            return first + second;
        }
        return fibonacci(second, first+second, ++cnt, n);
    }
}
