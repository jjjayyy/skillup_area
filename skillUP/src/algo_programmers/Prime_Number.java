package algo_programmers;

import java.util.ArrayList;
import java.util.List;

public class Prime_Number {
    static boolean[] visited;
    static List<Integer> resultNumbers = new ArrayList<>();
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        visited = new boolean[numbers.length()];

        // r개 뽑기위한 루프
        for(int i = 1; i <= numbers.length(); i++) {
            dfs(visited, i,0, numbers);
        }
        return resultNumbers.size();
    }

    // nPr n개중 r개 뽑기
    // r : 뽑는 수
    // depth : 탐색 깊이
    private static void dfs(boolean[] visited, int r, int depth, String numbers) {
        if(r == depth) {
            int num = Integer.parseInt(builder.toString());
            if(!resultNumbers.contains(num) && isPrime(num)) {
                resultNumbers.add(num);
                return;
            }
        }

        for(int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                builder.append(numbers.charAt(i));
                dfs(visited, r, depth + 1, numbers);
                builder.deleteCharAt(depth);
                visited[i] = false;
            }
        }
    }

    private static boolean isPrime(int number) {
        if(number < 2) {
            return false;
        }

        boolean isPrime = true;

        for(int i = 2; i < number; i++) {
            if(number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
