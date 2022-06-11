package algo_programmers;
import java.util.*;

public class N_expression {
    public static void main(String[] args) {
        solution(5,55);
    }

    static int min = Integer.MAX_VALUE;
    public static int solution(int N, int number) {
        dfs(N, number, 0, 0);
        if(min == Integer.MAX_VALUE) return -1;

        return min;
    }

    private static void dfs(int N, int number, int depth, int currNum) {
        if(depth > 8) return;

        if(number == currNum) {
            min = Math.min(depth, min);
        }

        int temp = 0;
        for(int i = 0; i < 8; i++) {
            if(depth + i < 8) {
                temp = temp * 10 + N;
                dfs(N, number, depth + i + 1, currNum + temp);
                dfs(N, number, depth + i + 1, currNum - temp);
                dfs(N, number, depth + i + 1, currNum * temp);
                dfs(N, number, depth + i + 1, currNum / temp);
            }
        }
    }


    public static int solution2(int N, int number) {
        List<Set<Integer>> countList = new ArrayList<>();

        for(int i=0; i<9; i++)
            countList.add(new HashSet<>());

        countList.get(1).add(N); // N을 1개 쓴 값은 N 혼자이다.

        for(int i=2; i<9; i++){
            Set<Integer> countSet = countList.get(i);

            for(int j=1; j<=i; j++){
                Set<Integer> preSet = countList.get(j);
                Set<Integer> postSet = countList.get(i - j);

                for(int preNum : preSet){
                    for(int postNum : postSet){
                        countSet.add(preNum + postNum);
                        countSet.add(preNum - postNum);
                        countSet.add(preNum * postNum);

                        if(preNum != 0 && postNum != 0)
                            countSet.add(preNum / postNum);
                    }
                }
            }

            countSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        for(Set<Integer> sub : countList){
            if(sub.contains(number))
                return countList.indexOf(sub);
        }

        return -1;
    }
}
