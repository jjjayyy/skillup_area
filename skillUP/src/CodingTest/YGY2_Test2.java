package CodingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class YGY2_Test2 {

    public static void main(String[] args) {
        int[] A = {6,2,3,5,6,3};
        System.out.println(solution(A));
    }

    static int solution(int[] A) {

        boolean[] numCheckArr = new boolean[A.length];
        List<Integer> dupNumList = new ArrayList<>();

        if(isNotDuplicated(A)) {
            return 0;
        }

        for(int num : A) {
            if(numCheckArr[num-1]) {
                dupNumList.add(num - 1);
            }
             numCheckArr[num-1] = true;
        }

        dupNumList = dupNumList.stream().sorted().collect(Collectors.toList());

        int result = 0;
        int index = 0;
        for(int i = 0; i < A.length; i++) {
            if(result > 1000000000) {
                return -1;
            }

            if(!numCheckArr[i]) {
                int dupNum = dupNumList.get(index);
                result += Math.abs(dupNum - i);
                index++;
            }
        }
        return result;

    }

    private static boolean isNotDuplicated(int[] A) {
        return Arrays.stream(A).distinct().count() == A.length;
    }

    //GetMapping만 사용 return 200
    //PutMapping / PostMapping / DeleteMapping 은 405에러
    //Content-Type 헤더가 있으면 application/json
    //파라미터 없으면 400에러
}
