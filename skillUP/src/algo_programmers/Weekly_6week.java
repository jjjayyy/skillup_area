package algo_programmers;

public class Weekly_6week {

    public static void main(String[] args) {

        int[] weights = {50, 82, 75, 120};
        String[] head2head = {"NLWL","WNLL","LWNW","WWLN"};

        solution(weights, head2head);
    }

    public static int[] solution(int[] weights, String[] head2head) {
        int[] answer = {};

        double[] percentage = new double[weights.length];
        for(int i = 0; i < head2head.length; i++) {
            String temp = head2head[i].replace("W", "");
            double winCnt = head2head[i].length() - temp.length();
            percentage[i] =  Math.floor(winCnt / (head2head.length-1) * 10000)/100;
        }

        for(double per : percentage) {
            System.out.println(per);
        }

        return answer;
    }
}
