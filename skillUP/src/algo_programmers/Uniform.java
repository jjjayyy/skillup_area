package algo_programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Uniform {
    public static void main(String[] args) {
        int[] lost = {3, 1, 2};
        int[] reserve = {2, 4, 3};

        int[] p = new int[4];

        for(int l : lost) {
            p[l-1]--;
        }

        System.out.println(solution(4, lost, reserve));
    }

    static int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = Arrays.stream(lost).boxed().sorted().collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve).boxed().sorted().collect(Collectors.toList());
        List<Integer> tempList = new ArrayList<>(lostList);

        lostList.removeAll(reserveList);
        reserveList.removeAll(tempList);

        for(int i = 0; i < lostList.size(); i++) {
            if(reserveList.isEmpty()) {
                break;
            }

            for(int j = 0; j < reserveList.size(); j++) {
                int lostNum = lostList.get(i);
                int rNum = reserveList.get(j);

                if(lostNum == rNum || lostNum+1 == rNum || lostNum-1 == rNum) {
                    lostList.remove(i);
                    reserveList.remove(j);
                   // if(i > 0) {
                        i--;
                   // }
                    break;
                }
            }
        }
        return n - lostList.size();
    }
}
