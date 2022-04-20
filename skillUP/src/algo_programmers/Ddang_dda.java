package algo_programmers;

public class Ddang_dda {
    public static void main(String[] args) {
        int[][] land = {{4,3,2,1},{2, 2, 2, 1},{6, 100, 6, 4},{8, 7, 6, 5}};
        System.out.println(solution(land));
    }

    private static int maxSum = 0;
    public static int solution(int[][] land) {
//        dp(land,4,0, 0);
//        return maxSum;
        int answer = 0 ;
        for(int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i-1][1], land[i-1][2]));
        }

        for(int i : land[land.length-1]) {
            answer = Math.max(answer, i);
        }

        return answer;
    }

    private static int dp(int[][] land, int visitedIdx, int landLevel, int sum) {
        if(land.length == landLevel) {
            maxSum = Math.max(maxSum, sum);
            return sum;
        }

        for(int i = 0; i < land[landLevel].length; i++) {
            if(i == visitedIdx) continue;

            sum += land[landLevel][i];
            if(sum > 100) continue;
            dp(land,i,landLevel+1,sum);
            sum -= land[landLevel][i];
        }
        return sum;
    }


}
