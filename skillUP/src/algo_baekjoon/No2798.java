package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2798 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        String[] temp2 = br.readLine().split(" ");

        int[] numbers = new int[N];

        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(temp2[i]);
        }

        Arrays.sort(numbers);

        int result = 0;
        int sum = 0;

        loop1:
        for(int i = 0; i < numbers.length; i++) {
            if(M <= numbers[i]) {
                continue;
            }
            loop2:
            for(int j = i+1; j < numbers.length; j++) {
                sum = numbers[i] + numbers[j];
                if(M <= sum) {
                    sum -= numbers[j];
                    continue;
                }
                loop3:
                for(int k = j+1; k < numbers.length; k++) {
                    sum += numbers[k];
                    if(M < sum) {
                        sum -= numbers[k];
                        break;
                    }
                    if(M > sum) {
                        result = Math.max(result, sum);
                        sum -= numbers[k];
                    } else if(M == sum) {
                        result = sum;
                        break loop1;
                    }
                }
            }
        }

        System.out.println(result);
    }


}
