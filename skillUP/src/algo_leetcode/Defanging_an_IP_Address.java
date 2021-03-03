package algo_leetcode;

public class Defanging_an_IP_Address {
    public static void main(String[] args) {

    }

    public static String defangIPaddr(String address) {
        char[] charArr = address.toCharArray();
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < charArr.length; i++) {
            if(charArr[i] == '.') {
                builder.append("[");
            }
            builder.append(charArr[i]);
        }
        return builder.toString();
    }
}
