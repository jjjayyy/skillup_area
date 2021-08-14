package CodingTest;

public class TOSS_Test3 {

    public static void main(String[] args) {

       String a = "123";

        System.out.println(solution(",,,,,,,,,,,,,,,"));
    }

    public static  boolean solution(String amountText) {
        if(!amountText.matches("^[0-9,]+$")) {
            return false;
        }

        if(amountText.length() != 1 && amountText.startsWith("0")) {
            return false;
        }

        if(amountText.startsWith(",")) {
            return false;
        }

        if(amountText.contains(",")) {
            int cnt = 0;
            for(int i = amountText.length()-1; i >= 0; i--) {
                cnt++;

                if(cnt % 4 != 0 && ',' == amountText.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
