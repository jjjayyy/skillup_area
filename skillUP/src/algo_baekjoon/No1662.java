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

        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(') {
                stack.push(builder.toString());
                builder.setLength(0);

                continue;
            }

            if(S.charAt(i) == ')') {
                if(builder.length() > 0)
                stack.push(builder.toString());

                builder.setLength(0);

                if(stack.isEmpty()) {
                    length += stack.pop().length();
                } else {
                    String temp = stack.pop();
                    if(temp.length() > 0)
                    length = length * (temp.charAt(temp.length()-1) - '0') + temp.length()-1;
                }

                continue;
            }
            builder.append(S.charAt(i));
        }
        if(builder.length() > 0) {
            length = builder.length();
        }

        if(!stack.isEmpty()) {
            String temp = stack.pop();
            length = length * (temp.charAt(temp.length()-1) - '0') + temp.length()-1;
        }
        System.out.println(length);
    }
}
