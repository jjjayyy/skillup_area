package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No2751 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> nList = new ArrayList<>();
        //int[] nArr = new int[n];

        for(int i = 0; i < n; i++) {
            //nArr[i] = Integer.parseInt(br.readLine());
            nList.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(nList);
        nList.forEach(System.out::println);

        //Arrays.stream(nArr).sorted().forEach(System.out::println);
    }
}
