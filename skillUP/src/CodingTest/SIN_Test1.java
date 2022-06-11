package CodingTest;

public class SIN_Test1 {
    public static void main(String[] args) {

        System.out.println(stringBeautify("o"));
    }

    public static String stringBeautify(String input)
    {
        StringBuilder stringBuilder = new StringBuilder();
        String distinctChar = "aeiou";
        String temp = "";
        boolean isEqualsToPreChar = false;
        for(int i = 0; i < input.length(); i++) {
            String currChar = input.charAt(i) + "";
            boolean isEqualsToCurrChar = distinctChar.contains(currChar);

            if(isEqualsToPreChar && isEqualsToCurrChar) {
                continue;
            }
            isEqualsToPreChar = isEqualsToCurrChar;
            stringBuilder.append(currChar);
            temp = currChar;
        }

        return stringBuilder.toString();
    }
}
