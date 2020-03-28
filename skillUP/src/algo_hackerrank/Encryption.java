package algo_hackerrank;

public class Encryption {

    // Complete the encryption function below.
    static void encryption(String s) {

        int rows = (int) Math.sqrt(s.length());
        int columns = rows * rows == s.length() ? rows : rows + 1;

        if(rows * columns < s.length()) {
            rows += 1;
        }

        String[] rowArr = new String[rows];
        String tempSentence = s;

        for(int i = 0; i < rows; i++) {
            rowArr[i] = i == rows - 1 ? tempSentence : tempSentence.substring(0, columns);
            if(i < rows - 1) {
                tempSentence = tempSentence.substring(columns);
            }
        }

        String result = "";

        for(int i = 0; i < columns; i++) {
            for(int j = 0; j < rows; j++) {

                if(j == rows -1) {
                    if(i < rowArr[j].length()) {
                        result += rowArr[j].charAt(i);
                    }
                } else {
                    result += rowArr[j].charAt(i);
                }
            }
            if(i != columns -1) {
                result += " ";
            }
        }
        System.out.println(result);



    }

    public static void main(String[] args) {
        encryption("iffactsdontfittotheorychangethefacts");
    }

}
