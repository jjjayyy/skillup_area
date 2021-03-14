package algo_programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Network {

    public static void main(String[] args) {
        int[][] computers = {{1,1,0}, {1,1,1}, {0,1,1}};
        int n = 3;

        System.out.println(bfs(n, computers));
    }

    public static int bfs(int n, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                continue;
            }
            q.offer(i);
            visited[i] = true;

            while(!q.isEmpty()) {
                int node = q.poll();

                for(int j = 0; j < n; j++) {
                    if(!visited[j] && node != j && computers[node][j] == 1) {
                        q.offer(j);
                        visited[j] = true;
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }
}
