package algo_programmers;

public class Num_Engword {
    public static void main(String[] args) {
        System.out.println(solution("23four5six7"));
    }

    public static int solution(String s) {
        int index = 0;
        String[] numWords = {"zero", "one", "two", "three", "four",
                            "five", "six", "seven", "eight", "nine"};

        while(!isDigit(s)) {
            s = s.replaceAll(numWords[index], String.valueOf(index));
            index++;
        }

        return Integer.parseInt(s);
    }

    private static boolean isDigit(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
