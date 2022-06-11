package CodingTest;

import java.util.Stack;

public class SSG_Test2 {

    public static void main(String[] args) {
        String[] pars = {")({[(){{()}}]", "([])", "[()]()[{}]","(}", "{}", "[]", "()"};
        solution(pars);
    }

    public static int[] solution(String[] pars) {
        int[] answer = new int[pars.length];

        Stack<Character> stack = new Stack<>();
        String openBrackets = "[{(";
        String closeBrackets = "]})";

        for(int i = 0; i < pars.length; i++) {
            stack.clear();
            for(int j = 0; j < pars[i].length(); j++) {
                char currBracket = pars[i].charAt(j);
                if(openBrackets.contains(currBracket + "")) {
                    if(stack.size() > 0 && openBrackets.indexOf(stack.peek()) > openBrackets.indexOf(currBracket)) {
                        break;
                    }
                    stack.push(currBracket);
                } else {
                    if(stack.isEmpty()) {
                        stack.push('T');
                        break;
                    }

                    if(openBrackets.indexOf(stack.peek()) != closeBrackets.indexOf(currBracket)) {
                        break;
                    }
                    stack.pop();
                }
            }
            answer[i] = stack.size() > 0 ? 0 : 1;
        }
        return answer;
    }

}
