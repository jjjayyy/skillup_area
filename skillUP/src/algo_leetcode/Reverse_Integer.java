package algo_leetcode;

public class Reverse_Integer {

    public static void main(String[] args) {
        reverse(1534236469);
    }

    public static int reverse(int x) {
        try {
            String xStr = String.valueOf(Math.abs(x));
            StringBuilder builder = new StringBuilder();

            if(x < 0) {
                builder.append("-");
            }
            for(int i = xStr.length()-1; i >= 0; i--) {
                builder.append(xStr.charAt(i));
            }
            return Integer.parseInt(builder.toString());
        } catch(Exception e) {
            return 0;
        }

//        int result = 0;
//
//        while (x != 0)
//        {
//            int tail = x % 10;
//            int newResult = result * 10 + tail;
//            if ((newResult - tail) / 10 != result)
//            { return 0; }
//            result = newResult;
//            x = x / 10;
//        }
//
//        return result;
    }
}
