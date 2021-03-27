package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class No1541 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String formula = br.readLine();
        String pattern = "^[0-9]$";
        StringBuilder builder = new StringBuilder();
        List<Integer> tempNumbers = new ArrayList<>();
        int tempNum = 0;

        for(int i = 0; i < formula.length(); i++) {
            String tempChar = formula.charAt(i) + "";
            if(Pattern.matches(pattern, tempChar)) {
                builder.append(tempChar);
            } else {
                tempNum += Integer.parseInt(builder.toString());
                if(tempChar.equals("-")) {
                    tempNumbers.add(tempNum);
                    tempNum = 0;
                }
                builder.setLength(0);
            }

            if(i == formula.length()-1) {
                int num =  Integer.parseInt(builder.toString());
                if(tempNum == 0) {
                    tempNumbers.add(num);
                } else {
                    tempNum += num;
                    if (!tempNumbers.isEmpty()) {
                        tempNumbers.add(tempNum);
                    }
                }
            }
        }
        if(!tempNumbers.isEmpty()) {
            tempNum = 0;
            for(int i = 0; i < tempNumbers.size(); i++) {
                if(i > 0) {
                    tempNum -= tempNumbers.get(i);
                } else {
                    tempNum += tempNumbers.get(i);
                }
            }
        }
        System.out.println(tempNum);
    }
}
