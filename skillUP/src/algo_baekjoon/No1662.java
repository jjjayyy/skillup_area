package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class No1662 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        Stack<Integer> stackByLen = new Stack<>();
        Stack<Integer> stackByMul = new Stack<>();

        int length = 0;
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(') {
                length--;
                stackByMul.push(S.charAt(i-1) - '0');
                stackByLen.push(length);
                length = 0;
                continue;
            }

            if(S.charAt(i) == ')') {
                length = stackByMul.pop() * length + stackByLen.pop();
                continue;
            }
            length++;
        }
        System.out.println(length);
    }
}
