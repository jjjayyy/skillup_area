package CodingTest;

import java.util.ArrayList;
import java.util.List;

public class NFin_Test1 {

    public static void main(String[] args) {
        String[] record = {"P 300 6", "P 500 3", "S 1000 4", "P 600 1", "S 1200 2"};
        solution(record);
    }

    public static int[] solution(String[] record) {
        int[] answer = new int[2];

        List<Integer> amountList = new ArrayList<>();
        List<Integer> countListByFIFO = new ArrayList<>();
        List<Integer> countListByFILO = new ArrayList<>();

        for (String rec : record) {
            String[] recArr = rec.split(" ");

            int amt = Integer.parseInt(recArr[1]);
            int cnt = Integer.parseInt(recArr[2]);

            if (recArr[0].equals("S")) {
                int calcCnt = cnt;

                for(int i = 0; i < amountList.size(); i++) {
                    int temp = calcCnt;
                    answer[0] += amountList.get(i) * (calcCnt < countListByFIFO.get(i) ? calcCnt : countListByFIFO.get(i));

                    calcCnt -= countListByFIFO.get(i);
                    countListByFIFO.set(i, countListByFIFO.get(i) - temp);

                    if(calcCnt <= 0) break;
                }

                for(int i = amountList.size()-1; i >= 0; i--) {
                    int temp = cnt;
                    answer[1] += amountList.get(i) * (cnt < countListByFILO.get(i) ? cnt : countListByFILO.get(i));

                    cnt -= countListByFILO.get(i);
                    countListByFILO.set(i, countListByFILO.get(i) - temp < 0 ? 0 :  countListByFILO.get(i) - temp );

                    if(cnt <= 0) break;
                }

                continue;
            }

            amountList.add(amt);
            countListByFIFO.add(cnt);
            countListByFILO.add(cnt);
        }

        return answer;
    }
}
