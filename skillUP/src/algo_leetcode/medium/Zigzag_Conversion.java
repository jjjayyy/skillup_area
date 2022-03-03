package algo_leetcode.medium;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Zigzag_Conversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }

    public static String convert(String s, int numRows) {
        if(s.length() < numRows || numRows == 1) return s;

        StringBuilder[] builderArr = new StringBuilder[numRows];
        int arrIndex = 0;
        boolean isReversed = false;

        for(int i = 0; i < numRows; i++) {
            builderArr[i] = new StringBuilder();
        }

        for(int i = 0; i < s.length(); i++) {
            builderArr[arrIndex].append(s.charAt(i));
            arrIndex = isReversed ? arrIndex - 1 : arrIndex + 1;

            if(arrIndex == numRows - 1) isReversed = true;
            if(arrIndex == 0) isReversed = false;
        }

        return Arrays.stream(builderArr).collect(Collectors.joining());
    }
}
