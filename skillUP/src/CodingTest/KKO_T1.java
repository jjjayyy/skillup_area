package CodingTest;

import java.util.HashMap;
import java.util.Map;

public class KKO_T1 {
    public static void main(String[] args) {
        solution("523817", "371648295");    //8
//        solution("3999", "735194826");    //1
//        solution("13722327", "481729356");    //7
    }
    public static int solution(String s, String keypad) {
          Map<Character, Integer> rowMap = new HashMap<>();
          Map<Character, Integer> colMap = new HashMap<>();
          Map<Character, int[]> arrMap = new HashMap<>();

          int rowIdx = -1;
          for(int i = 0; i < keypad.length(); i++) {
              int tempColCnt = i % 3;
              if(tempColCnt == 0) {
                  rowIdx++;
              }
              rowMap.put(keypad.charAt(i), rowIdx);
              colMap.put(keypad.charAt(i), tempColCnt);
          }

          int prevRow = 0;
          int prevCol = 0;
          char prevNum = ' ';
          int sec = 0;
          for(int i = 0; i < s.length(); i++) {
              if(prevNum == s.charAt(i)) {
                  continue;
              }
              int currRow = rowMap.get(s.charAt(i));
              int currCol = colMap.get(s.charAt(i));

              if(i > 0) {
                  int distanceRow = Math.abs(prevRow - currRow);
                  int distanceCol = Math.abs(prevCol - currCol);
                  sec = (distanceRow == 2 || distanceCol == 2) ? sec + 2 : sec + 1;
              }
              prevRow = currRow;
              prevCol = currCol;
              prevNum = s.charAt(i);
          }
        System.out.println(sec);
        return sec;
    }
}
