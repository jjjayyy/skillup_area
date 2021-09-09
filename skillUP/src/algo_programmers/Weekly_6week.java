package algo_programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.reverseOrder;

public class Weekly_6week {

    public static class Boxer{
        double winRt;
        int winCnt;
        int weight;
        int num;

        Boxer(double winRt, int winCnt, int weight, int num) {
            this.winRt = winRt;
            this.winCnt = winCnt;
            this.weight = weight;
            this.num = num;
        }

        public double getWinRt() {
            return winRt;
        }

        public int getWinCnt() {
            return winCnt;
        }

        public int getWeight() {
            return weight;
        }

        public int getNum() {
            return num;
        }
    }

    public static void main(String[] args) {

        int[] weights = {50,82,75,120};
        String[] head2head = {"NLWL","WNLL","LWNW","WWLN"};

        solution(weights, head2head);
    }

    public static int[] solution(int[] weights, String[] head2head) {
        List<Boxer> list = new ArrayList<>();
        for(int i = 0; i < head2head.length; i++) {

            String temp = head2head[i].replace("W", "");
            double cnt = head2head[i].length() - temp.length();
            int totalFight = head2head[i].replace("N", "").length();
            double winRt =  totalFight == 0 ? 0 : cnt / totalFight;
            int winCnt = 0;

            for(int j = 0; j < head2head[i].length(); j++) {
                if(head2head[i].charAt(j) == 'W' && weights[i] < weights[j]) {
                    winCnt++;
                }
            }
            list.add(new Boxer(winRt, winCnt, weights[i], i+1));
        }

        list.sort(Comparator.comparing(Boxer::getWinRt, reverseOrder())
                .thenComparing(Boxer::getWinCnt, reverseOrder())
                .thenComparing(Boxer::getWeight, reverseOrder())
                .thenComparing(Boxer::getNum));

        for(Boxer boxer : list) {
            System.out.println(boxer.getNum());
        }
        return list.stream().map(Boxer::getNum).mapToInt(i -> i).toArray();
    }
}
