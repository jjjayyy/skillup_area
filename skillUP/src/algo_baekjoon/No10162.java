package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No10162 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int second = Integer.parseInt(br.readLine());

        int[] buttonArr = {300, 60, 10};
        StringBuilder builder = new StringBuilder();

        if(second % 10 != 0) {
            builder.append("-1");
        } else {
            for(int button : buttonArr) {
                if(button <= second) {
                    builder.append((second / button));
                    second %= button;
                } else {
                    builder.append("0");
                }
                builder.append(" ");
            }
        }
        System.out.println(builder.toString());
    }
}
