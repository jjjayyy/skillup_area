package algo_programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Pass_Bridge {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        int onTheBridge = 0;
        int remainLength = 0;
        int sec = 0;

        ////////////////////////

        Queue<Integer> bridgeQ = new LinkedList<>();
        int idx = 0;
        int answer = 0;

        while(idx < truck_weights.length) {
            answer++;
            int curTruck = truck_weights[idx];

            if()
        }





        /////////////////////////




        int truckSec = 0;
        int tempTruck = 0;




        Queue<Integer> queue = new LinkedList<>();

        for(int truck : truck_weights) {
            queue.offer(truck);
        }

        while(!queue.isEmpty()) {

            boolean weightChk = true;

            if(onTheBridge > 0) {
                if(onTheBridge + queue.peek() > weight) {
                    weightChk = false;
                    sec += bridge_length - truckSec;
                    onTheBridge -= tempTruck;
                    tempTruck = 0;
                    truckSec = 0;
                }
            }
            if(weightChk) {
                tempTruck = queue.poll();
                onTheBridge += tempTruck;
            }
            truckSec++;
            sec++;
        }
        sec += bridge_length;
        return sec;
    }

    public static void main(String[] args) {
        int[] truckArr = {1, 1, 1, 1, 1, 2, 2};

        System.out.println(solution(5, 5, truckArr));
    }

}
