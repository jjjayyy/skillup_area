package algo_programmers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Heap_Hotter {

    public static void main(String[] args) {

    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        int mixedFood = 0;
        List<Integer> scovilleList = IntStream.of(scoville).boxed().collect(Collectors.toList());

        while(mixedFood < K) {
            int firstMileFood = Collections.min(scovilleList);
            scovilleList.remove(firstMileFood);
            int secondMileFood = Collections.min(scovilleList);
            scovilleList.remove(secondMileFood);

            mixedFood = firstMileFood + (secondMileFood * 2);
            answer++;
        }

        return answer;
    }

    private int mildFood(List<Integer> scovilleList) {
        return
    }
}
