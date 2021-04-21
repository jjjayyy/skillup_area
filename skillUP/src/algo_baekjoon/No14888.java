package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No14888 {
    static boolean[] visited;
    static List<Integer> resultList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] calTemp = br.readLine().split(" ");

        resultList = new ArrayList<>();



    }

    static void dfs(int N, int depth, int sum, int[] numArr) {
        if(N == depth) {
            resultList.add(sum);
            return;
        }

        for(int i = 0; i < numArr.length; i++) {
            if(!visited[i]) {

            }
        }
    }
}
