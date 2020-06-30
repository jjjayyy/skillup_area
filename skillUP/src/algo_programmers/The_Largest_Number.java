package algo_programmers;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        int[] reco = {4, 17, 20, 21, 23, 24};

        ArrayList<Integer> numList = new ArrayList<>();
        List<Integer> recoList = Arrays.stream(reco).boxed().collect(Collectors.toList());

        for(int i = 1; i < 46; i++) {
            if(!recoList.contains(i)) {
                numList.add(i);
            }
        }

        for(int i = 0; i < 3; i++) {
            Collections.shuffle(numList);
            System.out.println(numList.get(0));
            numList.remove(0);
        }
        System.out.println("=========== Recommand===========");
        for(int i = 0; i < 3; i++) {
            Collections.shuffle(recoList);
            System.out.println(recoList.get(0));
            recoList.remove(0);
        }

        System.out.println("=========== test ===========");
        String str = "2009-12-02T11:25:25.350";
        String[] strArr = str.split("T");
        System.out.println(strArr[0].replace("-",""));

        LocalDateTime dateTime = LocalDateTime.parse(str);
        String date = dateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(date);

    }

    private String rebaseTest() {
        return "";
    };

}
