package algo_programmers;

import java.util.Arrays;

public class Camera {
    public static void main(String[] args) {
        int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(solution(routes));
    }

    static public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        int min = routes[0][1];
        for(int i = 0; i < routes.length; i++) {
            if(min < routes[i][0]) {
                min = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}
