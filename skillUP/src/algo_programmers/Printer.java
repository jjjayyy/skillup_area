package algo_programmers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {

    public static void main(String[] args) {

    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i : priorities) {
            q.offer(i);
        }
            q[location];
        if(q.peek() == Collections.max(q)) {
            q.poll();
            answer++;
        } else {
            q.offer(q.poll());
        }


        return answer;
    }

}
