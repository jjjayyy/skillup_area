package algo_programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Island_Connection {

    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) {
        int[][] costs = {{0,1,5},{0,3,2},{0,4,3},{1,4,1},{3,4,10}, {1,2,2}, {2,5,3},{4,5,4}};
        System.out.println(solution(6, costs));
    }

    static int solution(int n, int[][] costs) {
        visited = new boolean[n];

//        Arrays.sort(costs, (o1, o2) -> {
//            if(o1[0] == o2[0]) {
//                return o1[2] - o2[2];
//            } else {
//                return o1[0] - o2[0];
//            }
//        });

        int[][] new_costs = new int[costs.length * 2][3];

        for(int i = 0; i < costs.length; i++) {
            new_costs[i][0] = costs[i][0];
            new_costs[i][1] = costs[i][1];
            new_costs[i][2] = costs[i][2];

            new_costs[i+costs.length][0] = costs[i][1];
            new_costs[i+costs.length][1] = costs[i][0];
            new_costs[i+costs.length][2] = costs[i][2];

        }

        bfs(costs, costs[0][0]);

        for(int i = 0; i < costs.length; i++) {
            if(!visited[costs[i][0]]) {
                bfs(costs, costs[i][0]);
            }
        }

        return cnt;
    }

    static void bfs(int[][] costs, int start) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int min = Integer.MAX_VALUE;

        while(!q.isEmpty()) {
            int startQ = q.poll();
            boolean isExsit = false;
            visited[startQ] = startQ == start ? false : true;
            int temp = 0;

            for(int i = 0; i < costs.length; i++) {
                if(startQ == costs[i][0] && !visited[costs[i][1]] && min > costs[i][2]) {
                    isExsit = true;
                    min = costs[i][2];
                    temp = costs[i][1];
                }
            }
            if(isExsit) {
                cnt += min;
                q.offer(temp);
            }
        }
    }
}
