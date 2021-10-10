package CodingTest;

public class YGY_Test2 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        String[] B = {".#..#","##..#","...#."};
        System.out.println(solution(B));
    }

    public static int[] solution(String[] B) {
        int[] result = new int[3];
        int M = B.length;
        int N = B[0].length();
        boolean[][] visited = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                 if(B[i].charAt(j) == '#' && !visited[i][j]) {
                    int cnt = dfs(i,j,B,visited, 0);
                    result[cnt-1]++;
                 }
            }
        }
        return result;
    }

    private static int dfs(int x, int y, String[] B, boolean[][] visited, int count) {
        if(visited[x][y]) {
            return count;
        }

        visited[x][y] = true;

        count++;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= B.length | ny >= B[0].length()) continue;

            if(B[nx].charAt(ny) == '#' && !visited[nx][ny]) {
                count = dfs(nx,ny,B,visited, count);
            }
        }
        return count;
    }
}
