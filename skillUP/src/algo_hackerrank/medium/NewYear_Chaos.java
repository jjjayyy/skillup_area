package algo_hackerrank.medium;

import java.util.Arrays;
import java.util.List;

public class NewYear_Chaos {
    public static void main(String[] args) {
        Integer[] arr =  {1, 2, 5, 3, 7, 8, 6, 4};
        List<Integer> q = Arrays.asList(arr);
        minimumBribes(q);
    }
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int sum = 0;
        for(int i = 0; i < q.size(); i++) {
            int temp = i + 1;
            if(q.get(i) - temp > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for(int j = Math.max(0, q.get(i) - 3); j < temp; j++) {
                if(q.get(i) < q.get(j)) {
                    sum++;
                }
            }

        }
        System.out.println(sum);
    }
}
