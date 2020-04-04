package algo_programmers;

import java.util.Arrays;

public class Failure_Rate {

    public static  int[] solution(int N, int[] stages) {
        int[] answer = {};

        Arrays.sort(stages);

        for(int i = 0; i < stages.length; i++) {

            if(i != 0 && stages[i] != stages[i-1]) {
                stages[i-1]

                stages[i]
            }
            stages[i]
        }

        return stages;
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(solution(3, arr));
    }

}
