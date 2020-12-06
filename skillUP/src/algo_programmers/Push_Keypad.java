package algo_programmers;

import java.util.Arrays;
import java.util.List;

public class Push_Keypad {

    public static String solution(int[] numbers, String hand) {
        List<Integer> leftPushList = Arrays.asList(1,4,7);
        List<Integer> rightPushList = Arrays.asList(3,6,9);
        List<Integer> anyPushList = Arrays.asList(2,5,8,0);
        StringBuilder builder = new StringBuilder();

        // * : 10
        // # : 12
        int nowLeftFinger =  10;
        int nowRightFinger = 12;

        for(int num : numbers) {
            if(leftPushList.contains(num)) {
                builder.append("L");
                nowLeftFinger = num;
            }

            if(rightPushList.contains(num)) {
                builder.append("R");
                nowRightFinger = num;
            }

            if(anyPushList.contains(num)) {
                if(num == 0) {
                    num = 11;
                }

                int leftTemp = Math.abs(nowLeftFinger - num);
                int rightTemp = Math.abs(nowRightFinger - num);

                int distanceByLeftFinger = leftTemp / 3 + leftTemp % 3;
                int distanceByRightFinger = rightTemp / 3 + rightTemp % 3;

                if(distanceByLeftFinger > distanceByRightFinger) {
                    nowRightFinger = num;
                    builder.append("R");
                } else if (distanceByLeftFinger < distanceByRightFinger) {
                    nowLeftFinger = num;
                    builder.append("L");
                } else {
                    if(hand.equals("left")) {
                        nowLeftFinger = num;
                        builder.append("L");
                    } else {
                        nowRightFinger = num;
                        builder.append("R");
                    }
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5, 4};
        String hand = "right";

        System.out.println(solution(numbers, hand));
    }


}
