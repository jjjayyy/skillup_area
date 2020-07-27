package algo_programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class The_Largest_Number {


    public String solution(int[] numbers) {
        String answer = "";
        return answer;
    }

    public static void main(String[] args) {
        int[] reco = {5, 6, 10, 13, 14, 20, 21, 22, 23, 25, 36, 37, 40, 45};

        ArrayList<Integer> numList = new ArrayList<>();
        List<Integer> recoList = Arrays.stream(reco).boxed().collect(Collectors.toList());

        for(int i = 1; i < 46; i++) {
            if(!recoList.contains(i)) {
                numList.add(i);
            }
        }

        for(int i = 0; i < 2; i++) {
            Collections.shuffle(numList);
            System.out.println(numList.get(0));
            numList.remove(0);
        }
        System.out.println("=========== Recommand===========");
        for(int i = 0; i < 4; i++) {
            Collections.shuffle(recoList);
            System.out.println(recoList.get(0));
            recoList.remove(0);
        }

    }

}
