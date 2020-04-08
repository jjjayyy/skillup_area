package algo_programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Pass_Bridge {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> truckTime = new LinkedList<>();
        int idx = 0;
        int answer = 0;
        int remainWeight = 0;

        while(idx < truck_weights.length) {
            answer++;
            int curTruck = truck_weights[idx];

            if(remainWeight + curTruck <= weight) {
                idx++;
                remainWeight += curTruck;
                truckTime.offer(0);
            }

            for(int i = 0; i < truckTime.size(); i++) {
                truckTime.offer(truckTime.poll() + 1);
            }

            if(truckTime.peek() == bridge_length) {
                remainWeight -= truck_weights[idx - truckTime.size()];
                truckTime.poll();
            }
        }

        return answer += bridge_length;
    }

    public static void main(String[] args) {
        int[] truckArr = {7, 4, 5, 6};

        System.out.println(solution(2, 10, truckArr));
    }

}
