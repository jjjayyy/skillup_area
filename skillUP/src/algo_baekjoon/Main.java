package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
    static StringBuilder builder;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        builder = new StringBuilder();
        arr = new int [M];

        dfs(N, M, 0);

        System.out.println(builder.toString());
    }

    static void dfs(int N, int M, int depth) {
        if(M == depth) {
            for(int num : arr) {
                builder.append(num).append(" ");
            }
            builder.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
                arr[depth] = i+1;
                dfs(N, M, depth+1);
        }
    }
}
