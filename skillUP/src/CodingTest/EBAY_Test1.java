package CodingTest;

public class EBAY_Test1 {

    public static void main(String[] args) {
        solution("000111");
    }

    public static int solution(String s) {
        while(s.length() > 0) {
            char flag = s.charAt(0) == '0' ? '1' : '0';
            if(!s.contains(String.valueOf(flag))) {
                break;
            }

            if(s.contains("10")) {
                s = s.replaceAll("10", "");
            }

            if(s.contains("01")) {
               s = s.replaceAll("01", "");
            }
        }
        return s.length();

//        StringBuilder sBuilder = new StringBuilder(s);
//        boolean isNotOnlyNumber = true;
//
//        while(sBuilder.length() > 0 && isNotOnlyNumber) {
//            char flagTemp = sBuilder.charAt(0);
//
//            for(int i = 0; i < sBuilder.length(); i++) {
//                if(flagTemp != sBuilder.charAt(i)) {
//                    sBuilder.delete(i - 1, Math.min(sBuilder.length(), i+1));
//                    break;
//                }
//                flagTemp = sBuilder.charAt(i);
//
//                if(i == sBuilder.length() - 1) {
//                    isNotOnlyNumber = false;
//                }
//            }
//        }
//        return sBuilder.length();
    }
}
