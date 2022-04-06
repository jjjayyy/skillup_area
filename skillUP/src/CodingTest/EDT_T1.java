package CodingTest;

import java.util.Stack;

public class EDT_T1 {
    public static void main(String[] args) {
        solution("2(2(hi)2(co))x2(bo)");
        solution("2(3(hi)co)");
//        solution("3(hi)");
/*        "3(hi)"	"hihihi"
        "2(3(hi)co)"	"hihihicohihihico"
        "10(p)"	"pppppppppp"
        "2(2(hi)2(co))x2(bo)"	"hihicocohihicocoxbobo"*/
    }

    public static String solution(String compressed) {
        String answer = "";
        StringBuilder builder = new StringBuilder();
        StringBuilder tempBuilder = new StringBuilder();
        Stack<String> cntStack = new Stack<>();
        Stack<String> wordStack = new Stack<>();
        int cntBracket = 0;

        for(int i = 0; i < compressed.length(); i++) {
            char c = compressed.charAt(i);
            if(isNumber(c)) {
                cntStack.push(c + "");
                continue;
            }

            if(c == '(') {
                cntBracket++;
                wordStack.push(tempBuilder.toString());
                tempBuilder.setLength(0);
                continue;
            }

            if(c == ')') {
                cntBracket--;

                int cnt = getCnt(cntStack.pop(), cntStack);
                String temp = tempBuilder.toString();
                for(int j = 1; j < cnt; j++) {
                    tempBuilder.append(temp);
                }

                if(cntBracket == 0) {
                    builder.append(tempBuilder.toString());
                    tempBuilder.setLength(0);
                }

                wordStack.push(tempBuilder.toString());
                tempBuilder.setLength(0);
                continue;
            }

            if(cntBracket == 0) {
                builder.append(c);
            } else {
                tempBuilder.append(c);
            }


        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    private static boolean isNumber(char c) {
        try {
            int temp = Integer.parseInt(c + "");
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static int getCnt(String num, Stack<String> cntStack) {
        int n = Integer.parseInt(num);
        if(n == 0) {
            n = getCnt(cntStack.pop() + num, cntStack);
        }
        return n;
    }
}
