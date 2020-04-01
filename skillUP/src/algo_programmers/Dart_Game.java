package algo_programmers;

import java.util.Arrays;

public class Dart_Game {

    public static int solution(String dartResult) {
        int[] scoreArr = new int[3];
        int idx = -1;
        boolean preDigit = false;

        for(int i = 0; i < dartResult.length(); i++) {
            if(Character.isDigit(dartResult.charAt(i))) {

                if(preDigit) {
                    scoreArr[idx] = 10;
                    continue;
                }

                scoreArr[++idx] = Character.getNumericValue(dartResult.charAt(i));
                preDigit = true;
                continue;
            }

            preDigit = false;
            switch(Character.toString(dartResult.charAt(i))) {
                case "D" : scoreArr[idx] = (int) Math.pow(scoreArr[idx], 2); break;
                case "T" : scoreArr[idx] = (int) Math.pow(scoreArr[idx], 3); break;
                case "#" : scoreArr[idx] *= (-1); break;
                case "*" :
                    if(idx == 0) {
                        scoreArr[idx] *= 2;
                    } else {
                        scoreArr[idx] *= 2;
                        scoreArr[idx-1] *= 2;
                    }
                    break;
            }
        }

        return Arrays.stream(scoreArr).sum();
    }

    public static void main(String[] args) {

        System.out.println(solution("1D2S#10S"));

    }
}
