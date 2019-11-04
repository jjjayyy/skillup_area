package algo_programmers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Heap_Hotter {

    public static void main(String[] args) {
        int[] scoville = {1,2,3,9,10,12};
        System.out.println(solution(scoville,7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        int mixedFood = 0;
        List<Integer> scovilleList = IntStream.of(scoville).boxed().collect(Collectors.toList());

        while(mixedFood < K) {
            int firstMildFood = mildScoville(scovilleList);
            int secondMildFood = mildScoville(scovilleList);

            mixedFood = firstMildFood + (secondMildFood * 2);

            scovilleList.add(mixedFood);
            answer++;
        }

        return answer;
    }

    private static int mildScoville(List<Integer> scovilleList) {
        int scoville = Collections.min(scovilleList);
        scovilleList.remove((Integer)scoville);
        return scoville;
    }
}
