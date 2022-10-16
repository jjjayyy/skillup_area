package algo_leetcode.easy;

public class Excel_Sheet_Column_Title {
    public static void main(String[] args) {
        convertToTitle(52);
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 26) {
            if(columnNumber % 26 == 0) {
                sb.insert(0, 'Z');
                columnNumber = columnNumber / 26 - 1;
            } else {
                sb.insert(0, (char)('A' + columnNumber % 26 - 1));
                columnNumber /= 26;
            }
        }

        sb.insert(0, (char)('A' + columnNumber - 1));

        System.out.println(sb.toString());
        return sb.toString();
    }
}
