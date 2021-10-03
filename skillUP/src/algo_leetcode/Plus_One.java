package algo_leetcode;

public class Plus_One {
    public static void main(String[] args) {
        int[] digits = {9,9};
        plusOne(digits);
    }

    public static int[] plusOne(int[] digits) {
        boolean isDigits = false;

       for(int i = digits.length-1; i >= 0; i--) {
           if(digits[i] + 1 > 9) {
               digits[i] = 0;
           } else {
               digits[i] = digits[i] + 1;
               return digits;
           }
       }

        digits=new int[digits.length+1];
        digits[0]=1;

       return digits;
    }
}
