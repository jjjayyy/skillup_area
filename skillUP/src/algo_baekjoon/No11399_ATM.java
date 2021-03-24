package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No11399_ATM {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] pArr = br.readLine().split(" ");
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(pArr[i]);
        }

        Arrays.sort(arr);

        int temp = 0;
        int sum = 0;

        for(int i = 0; i < pArr.length; i++) {
            sum += arr[i] + temp;
            temp += arr[i];
        }

        System.out.println(sum);
    }
}
