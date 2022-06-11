package CodingTest;

public class SSG_Test1 {
    public static void main(String[] args) {
        int[] numbers = {100, 101, 102, 103, 104};
        int[] start = {0,2};
        int[] finish = {2,4};

        solution(numbers, start, finish);
    }

    public static int[] solution(int[] numbers, int[] start, int[] finish) {
        int[] answer = new int[start.length];
        int[] accuSum = getAccuSum(numbers);

        for(int i = 0; i < start.length; i++) {
            int startIdx = start[i];
            int finishIdx = finish[i];

            if(startIdx == 0) {
                answer[i] = accuSum[finishIdx];
                continue;
            }

            answer[i] = accuSum[finishIdx] - accuSum[startIdx-1];
        }
        return answer;
    }

    private static int[] getAccuSum(int[] numbers) {
        int[] accuSum = new int[numbers.length];
        int temp = 0;
        for(int i = 0; i < numbers.length; i++) {
            temp += numbers[i];
            accuSum[i] = temp;
        }
        return accuSum;
    }
}
