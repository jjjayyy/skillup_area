package algo_leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Valid_Parentheses {

    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        String[] openBrackets = {"(", "{", "["};
        Stack<String> stack  = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));

            if(Arrays.asList(openBrackets).contains(str)) {
                stack.push(str);
            } else {
                if(!stack.isEmpty()) {
                    String stackPop = stack.pop();
                    if(stackPop.equals("(") && !str.equals(")")) {
                        return false;
                    }

                    if(stackPop.equals("{") && !str.equals("}")) {
                        return false;
                    }

                    if(stackPop.equals("[") && !str.equals("]")) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
