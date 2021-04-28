package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No9663 {
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
    }

    static void findQueen(int depth, int N) {
        if(depth == N) {
            count++;
            return;
        }
//
//        for(int i = 0; i < N; i++) {
//            arr[]
//        }
    }

}
