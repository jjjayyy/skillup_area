package algo_leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Happy_Number {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }


    public static boolean isHappy(int n) {
        int num = n;
        List<Integer> tempList = new ArrayList<>();

        while(num != 1) {
            int innerNum = 0;
            while(num > 0) {
                innerNum += Math.pow(num%10, 2);
                num /= 10;
            }
            if (tempList.contains(innerNum)) {
                return false;
            }
            tempList.add(innerNum);
            num = innerNum;
        }

        return num == 1;
    }

}
