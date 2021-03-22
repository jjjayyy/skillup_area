package algo_programmers;

import java.util.ArrayList;
import java.util.List;

public class Prime_Number {
    static boolean[] visited;
    static List<String> resultNumbers = new ArrayList<>();
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        solution("1234");
    }

    public static int solution(String numbers) {
        int answer = 0;

        visited = new boolean[numbers.length()];

        for(int i = 2; i <= numbers.length(); i++) {
            dfs(visited, i,0, numbers);
        }

        for(String a : resultNumbers) {
            System.out.println(a);
        }
        return answer;
    }

    public static void dfs(boolean[] visited, int r, int depth, String numbers) {
        if(builder.length() > 0 && r == depth) {
            resultNumbers.add(builder.toString());
            builder.delete(0,depth);
            return;
        }

        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i])  {
                visited[i] = true;
                builder.append(numbers.charAt(i));
                dfs(visited, r, depth+1, numbers);
                visited[i] = false;
            }
        }


    }
}
