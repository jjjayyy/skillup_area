package algo_Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lv3 {

    static int n, m;
    static String[] sequences;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        sequences = new String[n];
        for (int i = 0; i < n; i++) {
            sequences[i] = br.readLine();
        }

        visited = new boolean[n];
        int groupCount = 0;

        // 모든 노드를 탐색하며 그룹화 진행
        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 방문하지 않은 문자열이라면 새로운 그룹 시작
                groupCount++;
                dfs(i); // 연결된 모든 문자열 방문
            }
        }

        // 결과 출력
        System.out.println(groupCount);
    }

    // DFS로 연결된 문자열들을 방문
    static void dfs(int current) {
        visited[current] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && canBeGrouped(sequences[current], sequences[i])) {
                dfs(i);
            }
        }
    }

    // 두 문자열이 같은 그룹에 속할 수 있는지 확인
    static boolean canBeGrouped(String s1, String s2) {
        for (int i = 0; i < m; i++) {
            char char1 = s1.charAt(i);
            char char2 = s2.charAt(i);
            if (char1 != '.' && char2 != '.' && char1 != char2) {
                return false;
            }
        }
        return true;
    }
}
