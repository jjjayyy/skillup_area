package algo_programmers;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Heap_Hotter {

    public static void main(String[] args) {
        int[] scoville = {1,2,3,9,10,12};
        System.out.println(solution(scoville,7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int scov : scoville) {
            pq.offer(scov);
        }
        //pq.forEach((value) -> System.out.println(value));

        while(pq.peek() <= K) {
            if(pq.size() == 1) {
                return -1;
            }
            int first = pq.poll();
            int second = pq.poll();

            int result = first + (second * 2);

            pq.offer(result);
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
