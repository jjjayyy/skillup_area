package CodingTest;

public class EBAY_Test2 {

    public static void main(String[] args) {
        String[] numstrs = {"ZASSETE", "S4Z537B", "7_ASZEYB"};
        String[] words = {"2455373", "425", "373", "378"};

        solution(numstrs, words);
    }

    public static int[] solution(String[] numstrs, String[] words) {
        int[] answer = {};
        String[] signs = {"O()", "I", "ZS7_", "EB", "A", "ZS", "bG", "TY", "BE3", "gq"};
//        for()
//        Z; S;  2 / 5
//        B; 3/ 8

//        0	O(알파벳 대문자 오), ()
//        1	I(알파벳 대문자 아이)
//        2	Z, S, 7_
//        3	E, B
//        4	A
//        5	Z, S
//        6	b, G
//        7	T, Y
//        8	B, E3
//        9	g, q

        return answer;
    }

    private static void parseSignToNumstr(String sign) {
        if(sign.contains("()")) {
            sign = sign.replaceAll("\\(\\)", "0");
        }

        if(sign.contains("7_")) {
            sign = sign.replaceAll("7_", "2");
        }

        if(sign.contains("E3")) {
            sign = sign.replaceAll("E3", "8");
        }

//        sign()

        for(int i = 0; i < sign.length(); i++) {
//            if(sign.charAt(i))
        }
        System.out.println(sign);
//        return sign;
    }




}
