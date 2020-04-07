package algo_programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Pass_Bridge {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> bridgeQ = new LinkedList<>();
        int idx = 0;
        int answer = 0;
        int remainLength = bridge_length;
        int remainWeight = weight;

        while(idx < truck_weights.length) {
            answer++;
            int curTruck = truck_weights[idx];

            if(!bridgeQ.isEmpty() && remainWeight < curTruck) {
                answer += remainLength;
                remainWeight += bridgeQ.poll();
            }

            if(remainWeight == weight) {
                remainLength = bridge_length;
            }

            if(remainWeight >= curTruck) {
                remainLength -= 1;
                bridgeQ.offer(curTruck);
                remainWeight -= curTruck;
                idx++;
            }

            if(idx == truck_weights.length) {
                answer += bridge_length;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int[] truckArr = {7, 4, 5, 6};

        System.out.println(solution(2, 10, truckArr));
    }

}
