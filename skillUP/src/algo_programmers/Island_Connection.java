package algo_programmers;

import java.util.Arrays;

public class Island_Connection {

    static int cnt = 0;

    public static void main(String[] args) {
        //int[][] costs = {{0,1,5},{0,3,2},{0,4,3},{1,4,1},{3,4,10}, {1,2,2}, {2,5,3},{4,5,4}};
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        System.out.println(solution(4, costs));
    }

    static int solution(int n, int[][] costs) {

        Arrays.sort(costs, (o1, o2) -> {return o1[2] - o2[2];});

        int[] parents = new int[n];

        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for(int i = 0; i < costs.length; i++) {
            int start = getParent(parents, costs[i][0]);
            int end = getParent(parents, costs[i][1]);

            if(start != end) {
                parents[end] = start;
                cnt += costs[i][2];
            }
        }
        return cnt;
    }

    static int getParent(int[] parents, int child) {
        if(parents[child] == child) {
            return child;
        } else {
            return  getParent(parents, parents[child]);
        }

    }

}
