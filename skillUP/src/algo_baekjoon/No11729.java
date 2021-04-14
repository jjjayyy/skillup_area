package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No11729 {

    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        builder.append((int) Math.pow(2,n)).append("\n");

        hanoi(n, 1, 2, 3);
        System.out.println(builder.toString());
    }


    static void hanoi(int n, int from, int stopover, int to) {
        if(n == 1) {
            builder.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n-1, from, to, stopover);

        builder.append(from).append(" ").append(to).append("\n");

        hanoi(n-1, stopover, from, to);
    }
}