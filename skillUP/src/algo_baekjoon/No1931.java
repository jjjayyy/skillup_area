package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No1931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        List<String> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, (a,b) -> Integer.parseInt(a.split(" ")[1]) - Integer.parseInt(b.split(" ")[1]));
        result.add(list.get(0));
        list.remove(0);

        for(String item : list) {
            for(String resultItem : result) {
                int start = Integer.parseInt(item.split(" ")[0]);
                int resultEnd = Integer.parseInt(resultItem.split(" ")[1]);

                if(start >= resultEnd) {
                    result.add(item);
                }
            }
        }
        System.out.println(result.size());
    }
}
