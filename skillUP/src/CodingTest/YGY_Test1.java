package CodingTest;

import java.util.EmptyStackException;
import java.util.Stack;

public class YGY_Test1 {

    public static void main(String[] args) {
        System.out.println(solution("- -"));
    }


    public static int solution(String S) {
        String[] words = S.split(" ");
        Stack<Integer> numberStack = new Stack<>();
        int tempNum = 0;
        int tempNum2 = 0;

        try {
            for (String word : words) {
                switch (word) {
                    case "POP":
                        numberStack.pop();
                        break;
                    case "DUP":
                        numberStack.push(numberStack.peek());
                        break;
                    case "+":
                        tempNum = numberStack.pop();
                        tempNum2 = numberStack.pop();

                        numberStack.push(tempNum + tempNum2);
                        break;
                    case "-":
                        tempNum = numberStack.pop();
                        tempNum2 = numberStack.pop();

                        numberStack.push(calcStack(tempNum, tempNum2));
                        break;
                    default:
                        numberStack.push(Integer.parseInt(word));
                }
            }
            return numberStack.peek();
        } catch (EmptyStackException | IllegalStateException e) {
            return -1;
        }
    }

    private static int calcStack(int num, int num2) {
        if(num < num2) {
            throw new IllegalStateException();
        }
        return num - num2;
    }
}
