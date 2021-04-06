package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.*;

public class No1260 {

    static List<Integer> resultList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        int V = Integer.parseInt(temp[2]);

        int[][] mArr = new int [M*2][2];

        for(int i = 0; i < M; i++) {
            String[] tempStr = br.readLine().split(" ");
            int num1 = Integer.parseInt(tempStr[0]);
            int num2 = Integer.parseInt(tempStr[1]);

            mArr[i][0] = num1;
            mArr[i][1] = num2;

            mArr[i+M][0] = num2;
            mArr[i+M][1] = num1;
        }

        Arrays.sort(mArr, (o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
        });
        visited = new boolean[N];
        StringBuilder builder = new StringBuilder();
        dfs(mArr, V, builder);
        for(int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        bfs(mArr, V, builder);
        System.out.print(builder.toString());
    }

    static void dfs(int[][] mArr, int v, StringBuilder builder) {
        visited[v-1] = true;
        builder.append(v).append(" ");

        for(int i = 0; i < mArr.length; i++) {
            if(mArr[i][0] == v && !visited[mArr[i][1] - 1]) {
                dfs(mArr, mArr[i][1], builder);
            }
        }
    }

    static void bfs(int[][] mArr, int v, StringBuilder builder) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        builder.append("\n");
        visited[v-1] = true;

        while(!q.isEmpty()) {
            int num = q.poll();
            builder.append(num).append(" ");
            for(int i = 0; i < mArr.length; i++) {
                if(mArr[i][0] == num && !visited[mArr[i][1] - 1]) {
                    q.offer(mArr[i][1]);
                    visited[mArr[i][1] - 1] = true;
                }
            }
        }
    }

}
