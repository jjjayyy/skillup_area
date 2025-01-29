package algo_programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Lv2 {
    static boolean[][] sol2_visited;
    static int[] sol2_dirX = {0, 1, -1, 0};
    static int[] sol2_dirY = {1, 0, 0, -1};
    static int[][] sol2_dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우
    static int sol2_min = Integer.MAX_VALUE;

    public static void main(String[] args) {
//        solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2});

        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
//        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        System.out.println(solution2(maps));
    }

    public static int solution2(int[][] maps) {
        sol2_visited = new boolean[maps.length][maps[0].length];
//        dfs(0,0,maps,1);

//        return sol2_min == Integer.MAX_VALUE ? -1 : sol2_min;

        return bfs(maps.length, maps[0].length, maps);
    }

    public static int bfs(int n, int m, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        sol2_visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], distance = current[2];

            // 목적지 도달 시 최단 거리 반환
            if (x == n - 1 && y == m - 1) {
                return distance;
            }

            // 네 방향 탐색
            for (int[] dir : sol2_dir) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // 이동 가능 조건: 범위 내, 이동 가능(1)
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !sol2_visited[nx][ny] && maps[nx][ny] == 1) {
                    sol2_visited[nx][ny] = true; // 방문 처리 (다시 방문 방지)
                    queue.offer(new int[]{nx, ny, distance + 1});
                }
            }
        }
        return -1;
    }

    public static void dfs(int x, int y, int[][] maps, int sum) {
        if(sum >= sol2_min) return;

        if(x == maps.length-1 && y == maps[0].length-1) {
            sol2_min = Math.min(sol2_min, sum);
            return;
        }
        sol2_visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int dirX = x+sol2_dirX[i];
            int dirY = y+sol2_dirY[i];
            if(dirX >= 0 && dirY >= 0 && dirX < maps.length && dirY < maps[0].length && !sol2_visited[dirX][dirY] && maps[dirX][dirY] == 1) {
                dfs(dirX, dirY, maps, sum+1);
            }
        }
        sol2_visited[x][y] = false;
    }

    public static int solution(int[] topping) {
        int answer = 0;

        Map<Integer,Integer> firstMap = new HashMap<>();
        Map<Integer,Integer> tempMap = new HashMap<>();
        int firstCnt = 0;
        int tempCnt = 0;

        for(int i = 1; i < topping.length; i++) {
            if(!tempMap.containsKey(topping[i])) {
                tempCnt++;
            }
            tempMap.put(topping[i],tempMap.getOrDefault(topping[i],0) + 1);
        }

        for(int i = 0; i < topping.length-1; i++){
            if(!firstMap.containsKey(topping[i])) {
                firstMap.put(topping[i], 1);
                firstCnt++;
            }

            if(i > 0) {
                tempMap.put(topping[i], tempMap.get(topping[i])-1);
                if(tempMap.get(topping[i]) == 0) {
                    tempCnt--;
                }
            }
            if(firstCnt == tempCnt) {
                answer++;
            }
        }
        return answer;
    }
}
