package CodingTest;

import java.util.ArrayList;
import java.util.List;

public class NWT_Test2 {
    public static void main(String[] args) {
        String s = "abcxyqwertyxyabc";

        for(String a : solution(s)) {
            System.out.println(a);
        }
    }

    public static String[] solution(String s) {
        int index = 1;
        List<String> tempList = new ArrayList<>();
        List<String> tempListLast = new ArrayList<>();

        while(s.length() > 0) {
            if(index >= s.length()) {
                tempList.add(s);
                break;
            }
            String str = s.substring(0, index);
            String lastStr = s.substring(s.length()-index, s.length());

            if(!str.equals(lastStr)) {
                index++;
                continue;
            }

            s = s.substring(index, s.length()-index);
            index = 1;
            tempList.add(str);
            tempListLast.add(0, lastStr);
        }
        tempList.addAll(tempListLast);
        return tempList.toArray(new String[0]);
    }
}
