package algo_leetcode;

public class Defanging_an_IP_Address {
    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
    }

    public static String defangIPaddr(String address) {
//        for(int i = 0; i < charArr.length; i++) {
//        char[] charArr = address.toCharArray();
//        StringBuilder builder = new StringBuilder();
//
//            if(charArr[i] == '.') {
//                builder.append("[").append(charArr[i]).append("]");
//                continue;
//            }
//            builder.append(charArr[i]);
//        }
//        return builder.toString();

        return address.replace(".", "[.]");
    }
}
