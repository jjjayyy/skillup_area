package CodingTest;

import java.util.Arrays;

public class HHI_Test3 {
    public static void main(String[] args) {

//        int[] heights = {1, 4, 2, 5, 3};
//        int[] heights = {3, 4, 5, 6, 7};
//        int[] heights = {1, 99998, 99999};
        int[] heights = {5,5,5};
//        int[] heights = {3, 5, 4, 2, 4, 4, 6, 5};
//        int[] heights = {1,2};
        solution(heights);
    }

    public static int solution(int[] heights) {

        int answer = 0;
//        int superMax = Arrays.stream(heights).max().getAsInt();

        int superMax = 0;
        int temp = 0;
        for(int height : heights) {
            if(height == superMax) {
                temp++;
            }

            if(height > superMax) {
                superMax = height;
                temp = 1;
            }
        }


        for(int i = 0; i < heights.length; i++) {
            int max = 0;
            int base = heights[i];

//            if(temp == 1 && base == superMax) continue;
            if(base == superMax) {
                if(temp > 1) {
                    answer += temp-1;
                }
                continue;
            }

            for(int j = i+1; j < heights.length; j++) {
                if((max == 0 && base <= heights[j]) || (max != 0 && max < heights[j])) {
                    max = heights[j];
                    answer++;
                }

                if(max == superMax) {
                    break;
                }
            }

            max = 0;
            for(int k = i-1; k >= 0; k--) {
                if((max == 0 && base <= heights[k]) || (max != 0 && max < heights[k])) {
                    max = heights[k];
                    answer++;
                }

                if(max == superMax) {
                    break;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
}
