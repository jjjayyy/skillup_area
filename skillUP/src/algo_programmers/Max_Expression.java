package algo_programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Max_Expression {

    public static long solution(String expression) {
        long answer = 0;

        String[] numbers = expression.split("\\D");
        String[] operatorsInExpression = expression.split("\\d");
        List<String> operatorsListInExpression = Arrays.asList(operatorsInExpression).stream()
                                                                                    .filter(str -> !str.isEmpty())
                                                                                    .collect(Collectors.toList());

        String[][] operatorsArr = {{"*","-","+"},{"*","+","-"},{"+","-","*"},
                                    {"+","*","-"},{"-","+","*"},{"-","*","+"}};

        for(int i = 0; i < operatorsArr.length; i++) {
            answer = Math.max(answer, Math.abs(getMoney(operatorsArr[i], numbers, operatorsListInExpression)));
        }

        return answer;
    }

    private static long getMoney(String[] optArr, String[] numbers, List<String> optInExp) {

        List<String> numbersList = new ArrayList<>(Arrays.asList(numbers));
        List<String> optArrList = new ArrayList<>(Arrays.asList(optArr));
        List<String> optListInExp = new ArrayList<>(optInExp);

        for(String opt : optArrList) {
            for(int i = 0; i < optListInExp.size(); i++) {
                if(opt.equals(optListInExp.get(i))) {
                    numbersList.set(i+1, calc(Long.parseLong(numbersList.get(i)), Long.parseLong(numbersList.get(i+1)), opt));

                    numbersList.remove(i);
                    optListInExp.remove(i);
                    i--;
                }
            }
        }

        return Long.parseLong(numbersList.get(0));
    }

    private static String calc (long num1, long num2, String operator) {
        long result = 0;
        switch(operator) {
            case "+": result = num1 + num2; break;
            case "-": result = num1 - num2; break;
            case "*": result = num1 * num2; break;
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
    }


}
