package algo_programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Phoneketmon {

    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};
        System.out.println(solution(nums));
    }

    static public int solution(int[] nums) {
        int selectCnt = nums.length / 2;
        IntStream stream = Arrays.stream(nums).distinct();
        int duplicateCnt = stream.toArray().length;

        return selectCnt > duplicateCnt ? duplicateCnt : selectCnt;
    }

}
