package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No15650 {
    static boolean[] visited;
    static int[] arr;
    static StringBuilder builder;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        visited = new boolean[N];
        arr = new int[M];
        builder = new StringBuilder();

        dfs(N, M, 0, 0);
        System.out.println(builder.toString());
    }

    static void dfs(int N, int M, int depth, int index) {
        if(M == depth) {
            for(int num : arr) {
                builder.append(num).append(" ");
            }
            builder.append("\n");
            return;
        }

        if(index == N) {
            return;
        }

        for(int i = index; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}
