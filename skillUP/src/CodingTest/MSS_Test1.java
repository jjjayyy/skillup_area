package CodingTest;

public class MSS_Test1 {
    public static void main(String[] args) {
        int[][] price = {{112, 55, 42, 90, 20, 17, 18, 23},{105, 59, 38, 91, 21, 20, 20, 22},{100, 62, 33, 92, 22, 19, 22, 21},{101, 51, 30, 95, 25, 15, 24, 20},{107, 50, 38, 99, 23, 18, 21, 21},{112, 72, 40, 93, 21, 16, 23, 19},{105, 58, 39, 90, 22, 17, 21, 20},{108, 63, 31, 97, 21, 16, 20, 20},{114, 67, 32, 95, 24, 17, 17, 24}};
        solution(price);
    }


    public static int[] solution(int[][] price) {
        int[] answer = new int[2];
        int[] items = new int[8];
        for(int i = 0; i < items.length; i++) {
            items[i] = Integer.MAX_VALUE;
        }

        answer[1] = Integer.MAX_VALUE;

        for(int i = 0; i < price.length; i++) {
            int sum = 0;
            for(int j = 0; j < price[i].length; j++) {
                int item = price[i][j];
                items[j] = Math.min(items[j], item);
                sum += item;
            }
            answer[1] = Math.min(answer[1], sum);
        }

        for(int item : items) {
            answer[0] += item;
        }

        return answer;
    }


}
