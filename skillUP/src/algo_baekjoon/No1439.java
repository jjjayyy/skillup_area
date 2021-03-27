package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1439 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char baseChar = s.charAt(0);
        int cnt = 0;

        for(int i = 0; i < s.length(); i++) {
            if(baseChar != s.charAt(i) && ((i > 0) && s.charAt(i-1) != s.charAt(i))) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
