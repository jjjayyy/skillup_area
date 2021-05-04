package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No11054 {
    static int[] numArr;
    static int[] lisArr;
    static int[] ldsArr;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");

        numArr = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
        lisArr = new int[N];
        ldsArr = new int[N];

        lis();
        lds();

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            max = Math.max(max, (lisArr[i] + ldsArr[i]));
        }

        System.out.println(max-1);
    }

    static void lis() {
        for(int i = 0; i < N; i++) {
            lisArr[i] = 1;

            for(int j = 0; j < i; j++) {
                if(numArr[i] > numArr[j] && lisArr[i] < lisArr[j] + 1) {
                    lisArr[i] = lisArr[j] + 1;
                }
            }
        }
    }

    static void lds() {
        for(int i = N-1; i >= 0; i--) {
            ldsArr[i] = 1;

            for(int j = N-1; j > i; j--) {
                if(numArr[i] > numArr[j] && ldsArr[i] < ldsArr[j] + 1) {
                    ldsArr[i] = ldsArr[j] + 1;
                }
            }
        }
    }
}
