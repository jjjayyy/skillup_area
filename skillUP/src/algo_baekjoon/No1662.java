package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class No1662 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();

        int length = 0;
        int tempLength = 0;
        int cnt = 0;

        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(') {
                stack.push(builder.toString());
                builder.setLength(0);
                cnt++;
                continue;
            }

            if(S.charAt(i) == ')') {
                cnt--;
                if(builder.length() > 0) {
                    tempLength += builder.length();

                    builder.setLength(0);
                    continue;
                }
                if(cnt == 0) {
                    length += tempLength;
                    tempLength = 0;
                }

                String temp = stack.pop();
                if(temp.length() > 0)
                length = length * (temp.charAt(temp.length()-1) - '0') + temp.length()-1;
                continue;
            }
            builder.append(S.charAt(i));
        }

        if(!stack.isEmpty()) {
            String temp = stack.pop();
            length = length * (temp.charAt(temp.length()-1) - '0') + temp.length()-1;
        }

        if(builder.length() > 0) {
            length += builder.length();
        }

        System.out.println(length);
    }
}
