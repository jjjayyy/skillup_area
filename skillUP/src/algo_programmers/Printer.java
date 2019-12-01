package algo_programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class Printer {

    public static void main(String[] args) {

        int[] sample = {2,1,3,2};
        int location = 2;

        System.out.println(solution(sample, location));
    }

    public static int solution(int[] priorities, int location) {

        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int priority : priorities) {
            pq.offer(priority);
        }

        while(!pq.isEmpty()) {

            for(int i = 0; i < priorities.length; i++) {
                if(pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;
                    if (location == i) {
                        pq.clear();
                        break;
                    }
                }
            }
        }

        return answer;
    }

}
