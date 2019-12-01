package algo_programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class StockPrice {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 2, 3};
        for(int i : solution(test)) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] prices) {

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> downSeconds = new ArrayList<>();
        int second = 0;
        int index = 0;

        for(int price : prices) {
            q.offer(price);
        }
        while(!q.isEmpty()) {
            index++;
            if(index == prices.length) {
                break;
            }
            for(int i = index; i < prices.length; i++) {
                second++;
                if(q.peek() > prices[i]) {
                    downSeconds.add(second);
                    second = 0;
                    q.poll();
                    break;
                }
                if(i == prices.length - 1) {
                    downSeconds.add(second);
                    second = 0;
                    q.poll();
                }
            }
        }

        downSeconds.add(0);

        return downSeconds.stream().mapToInt(i -> i).toArray();
    }
}
