package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

    public class No14719 {
        public static void main(String[] args) throws Exception {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] hwArr = br.readLine().split(" ");
            int w = Integer.parseInt(hwArr[1]);

            String[] blockArr = br.readLine().split(" ");
            List<Integer> list = Arrays.stream(blockArr)
                    .mapToInt(str -> Integer.parseInt(str))
                    .boxed()
                    .collect(Collectors.toList());

            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                int left = 0;
                for (int j = 0; j < i; j++) {
                    left = Math.max(left, list.get(j));
                }

                int right = 0;
                for (int j = i; j < list.size(); j++) {
                    right = Math.max(right, list.get(j));
                }

                int water = Math.min(left, right) - list.get(i);
                sum += Math.max(water, 0);
            }
            System.out.println(sum);
        }
    }
