package algo_programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class The_Largest_Number {

    public static String solution(int[] numbers) {

        String[] strNumbers = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNumbers, (n1, n2) -> (n2+n1).compareTo((n1+n2)));

        if(strNumbers[0].equals("0")) {
            return "0";
        }
        return Arrays.asList(strNumbers).stream().collect(Collectors.joining());
    }

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        System.out.println(solution(numbers));
    }

}
