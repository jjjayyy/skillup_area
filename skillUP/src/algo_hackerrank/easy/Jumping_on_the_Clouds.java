package algo_hackerrank.easy;

import java.util.Arrays;
import java.util.List;

public class Jumping_on_the_Clouds {
    public static void main(String[] args) {
        Integer[] cArr = {0, 0, 1, 0, 0, 1, 0};
        List<Integer> c = Arrays.asList(cArr);
        jumpingOnClouds(c);
    }

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int result = 0;
        for(int i = 0; i < c.size(); i++) {
            result++;
            if(i+2 < c.size() && c.get(i+2) == 0) {
                i++;
            }
        }
        System.out.println(result);
        return result-1;
    }
}
