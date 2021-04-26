package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No14888 {
    static int[] operators;
    static int[] numArr;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        numArr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        operators = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        dfs(numArr[0], 1, N);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int num, int idx, int N) {
        if(N == idx) {
            max = Math.max(max,num);
            min = Math.min(min,num);
            return;
        }

        for(int i = 0; i < operators.length; i++) {
            if(operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0 : dfs(num + numArr[idx], idx+1, N); break;
                    case 1 : dfs(num - numArr[idx], idx+1, N); break;
                    case 2 : dfs(num * numArr[idx], idx+1, N); break;
                    case 3 : dfs(num / numArr[idx], idx+1, N); break;
                }
                operators[i]++;
            }
        }
    }
}
