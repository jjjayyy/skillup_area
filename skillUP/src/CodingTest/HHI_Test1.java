package CodingTest;

public class HHI_Test1 {
    public static void main(String[] args) {
//        int[][] taxes = {{1200, 6}, {4600, 15}, {8800, 24}, {15000, 35}, {0, 38}};
//        int[][] taxes = {{1000, 1}, {0, 10}};
        int[][] taxes = {{1500, 12}, {3500, 23}, {5700, 29}, {0, 30}};

        solution(taxes, 6400);
    }

    public static int solution(int[][] taxes, int income) {
        int result = 0;
        for(int i = 0; i < taxes.length; i++) {
            int prePeriodIncome = i > 0 ? taxes[i-1][0] : 0;
            int periodIncome = taxes[i][0];
            double tax = (double) taxes[i][1] / 100;

            if(i != taxes.length-1 && income > periodIncome) {
                periodIncome -= prePeriodIncome;
                result += periodIncome * tax;
            } else {
                result += (income - prePeriodIncome) * tax;
                break;
            }
        }
        System.out.println(result);
        return result;
    }
}
