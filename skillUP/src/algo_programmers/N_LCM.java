package algo_programmers;

import java.util.Arrays;

public class N_LCM {
    public static void main(String[] args) {
        int[] arr =  {2,6,8,14};
        solution(arr);
    }

    public static int solution(int[] arr) {
        int maxNum = Arrays.stream(arr).max().getAsInt();

        while(true) {
            int cnt = 0;
            for(int value : arr) {
                if(maxNum % value == 0) {
                    cnt++;
                }
            }

            if(cnt == arr.length) {
                break;
            }
            maxNum++;
        }
        System.out.println(maxNum);
        return maxNum;
    }
}
