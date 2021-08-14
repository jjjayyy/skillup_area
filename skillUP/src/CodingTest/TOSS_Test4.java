package CodingTest;

import java.util.HashMap;
import java.util.Map;

public class TOSS_Test4 {
    public static void main(String[] args) {

    }

    public String solution(String input) {
        StringBuilder builder = new StringBuilder();

        String[] inputArr = input.split("\n");
        Map<String, String> infoMap = new HashMap<>();
        infoMap.put("SHOW", "1");
        infoMap.put("NEGATIVE", "0");
        infoMap.put("NEXT", "-");
        infoMap.put("EXIT", "BYE");

        String[] mn = inputArr[0].split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);

        int mCnt = 0;
        int nCnt = 0;

        for(int i = 0; i < inputArr.length; i++) {
            String inputWord = inputArr[i];

            if(i == 0) {
                builder.append(inputWord);
            }

            if (!infoMap.containsKey(inputWord)) {
                builder.append("ERROR");
            }

            if(!inputWord.equals("SHOW")) {
                builder.append(infoMap.get(inputWord));
            }

            if(inputWord.equals("SHOW")) {
                nCnt++;
                builder.append("1");

                if(n == nCnt) {
                    builder.append("0");
                }
            }

            if(inputWord.equals("NEXT")) {
                mCnt++;
                if(m == mCnt) {
                    mCnt = 0;
                }
            }

            if(i != inputArr.length-1) {
                builder.append("\n");
            }
        }

        return builder.toString();
    }
}
