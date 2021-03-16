package algo_programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class H_Index {
    public static void main(String[] args) {
        int[] citations = {12, 11, 10, 9, 8, 1};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        List<Integer> list = Arrays.stream(citations).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        int count = 0;
        for(int i : list) {
            count++;
            if(i == count) {
                break;
            }
        }
        return count;
    }
}
