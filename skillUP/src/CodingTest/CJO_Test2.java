package CodingTest;

public class CJO_Test2 {

    static boolean[] visited;
    static int cnt = Integer.MAX_VALUE;
    static int tempCnt = 0;

    public static void main(String[] args) {
        String[] subway = {"1 2 3 4 5 6 7 8","2 11","0 11 10","3 17 19 12 13 9 14 15 10","20 2 21"};
        solution(subway, 1, 9);
    }

    public static int solution(String[] subway, int start, int end) {
        visited = new boolean[subway.length];

        for(int i = 0; i < subway.length; i++) {
            if(subway[i].contains(String.valueOf(start))) {
                visited[i] = true;
                dfs(subway, subway[i], String.valueOf(end));
                break;
            }
        }

        System.out.println(cnt);
        return cnt;
    }

    private static void dfs(String[] subway, String line, String end) {
        if(line.contains(end)) {
            cnt = Math.min(cnt, tempCnt);
            tempCnt = 0;
            return;
        }

        String[] lines = line.split(" ");

        for(int i = 0; i < lines.length; i++) {
            for(int j = 0; j < subway.length; j++) {
                if(!visited[j]) {
                    if(subway[j].contains(lines[i])) {
                        tempCnt++;
                        visited[j] = true;
                        dfs(subway, subway[j], end);
                        visited[j] = false;
                    }
                }
            }
        }
    }
}
