package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No14889 {
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int N;
    static int[][] statArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        statArr = new int[N][N];

        for(int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                statArr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        visited = new boolean[N];
        findVisited(0, 0);
        System.out.println(min);
    }

    static void findVisited(int idx, int count) {
        if(count == N/2) {
            findMin();
            return;
        }

        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                findVisited(i+1, count+1);
                visited[i] = false;
            }
        }
    }

    static void findMin() {
        int sumByTeam1 = 0;
        int sumByTeam2 = 0;

        for(int i = 0; i < N-1; i++) {
            for(int j = i+1; j < N; j++) {
                if(visited[i] && visited[j]) {
                    sumByTeam1 += statArr[i][j];
                    sumByTeam1 += statArr[j][i];
                } else if (!visited[i] && !visited[j]){
                    sumByTeam2 += statArr[i][j];
                    sumByTeam2 += statArr[j][i];
                }
            }
        }
        min = Math.min(min, Math.abs(sumByTeam1 - sumByTeam2));
    }
}
