package algo_programmers;

import java.util.Arrays;

public class Lotto_Best_Worst {

    public static void main(String[] args) {
        int[] lottos = {41, 2, 1, 21, 42, 19};
        int[] win_nums = {20, 9, 3, 45, 4, 35};

        solution(lottos, win_nums);
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCnt = (int) Arrays.stream(lottos).filter(i -> i == 0).count();
        int[] lottosWithoutZero = Arrays.stream(lottos).filter(i -> i != 0).toArray();
        int rank = 7;

        System.out.println(zeroCnt);

        for(int winNum : win_nums) {
            for(int lotto : lottosWithoutZero) {
                if(winNum == lotto) {
                    rank--;
                }
            }
        }
        answer[0] = Math.min(rank - zeroCnt, 6);
        answer[1] = Math.min(rank, 6);

        System.out.println(answer[0]);
        System.out.println(answer[1]);

        return answer;
    }
}
