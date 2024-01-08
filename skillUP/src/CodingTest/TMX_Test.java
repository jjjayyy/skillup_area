package CodingTest;

import java.util.*;

public class TMX_Test {

    static int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    static int[][] maze;
    static boolean[][] visited;
    public static void main(String[] args) {
//        String[] logs = {"morgan string_compare", "felix string_compare", "morgan reverse", "rohan sort", "andy reverse", "morgan sqrt"};
//        solution1(logs);
        int[] skills = {1,5,10,15};
        System.out.println(solution2(30,10,50,skills));

//        int[] msg = {1, 0, 0, 0, 1};
//        int[][] maze = {{1, 0, 0, 2, 2, 2, 2}, {2, 2, 1, 2, 1, 0, 2}, {2, 0, 1, 2, 2, 2, 2}, {2, 2, 2, 2, 1, 2, 2}, {2, 1, 0, 0, 1, 2, 2}};
//         solution3(msg, maze);
    }

    public static List<int[]> solution3(int[] msg, int[][] maze) {
        List<int[]> res = new ArrayList<>();
        int m = maze.length;
        int n = maze[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maze[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dirs[k][0], y = j + dirs[k][1];
                        if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                            List<Integer> path = new ArrayList<>();
                            dfs(x, y, k, path);
                            if (match(msg, path)) {
                                res.add(new int[]{i, j});
                                break;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    private static boolean match(int[] msg, List<Integer> path) {
        if (msg.length != path.size()) return false;
        for (int i = 0; i < msg.length; i++) {
            if (msg[i] != path.get(i)) return false;
        }
        return true;
    }

    private static void dfs(int x, int y, int d, List<Integer> path) {
        if (visited[x][y]) return;
        visited[x][y] = true;
        path.add(maze[x][y]);
        int nx = x + dirs[d][0], ny = y + dirs[d][1];
        if (nx >= 0 && nx < maze.length && ny >= 0 && ny < maze[0].length && maze[nx][ny] == 1) {
            dfs(nx, ny, d, path);
        } else {
            d = (d + 1) % 4;
            nx = x + dirs[d][0];
            ny = y + dirs[d][1];
            if (nx >= 0 && nx < maze.length && ny >= 0 && ny < maze[0].length && maze[nx][ny] == 0) {
                dfs(nx, ny, d, path);
            }
        }
    }



    public static int solution2(int x, int y, int m, int[] skills) {
        // Initialize the minimum number of skills to hunt monsters.
        int minSkills = Integer.MAX_VALUE;

        // Iterate over all skills.
        for (int skill : skills) {
            // Calculate the number of skills required to hunt monsters using the current skill.
            int skillsRequired = 0;
            int currentHp = m;
            while (currentHp > 0) {
                // If the monster's HP is less than or equal to x, recover its HP by y.
                if (currentHp <= x) {
                    currentHp += y;
                }

                // Reduce the monster's HP by the attack power of the current skill.
                currentHp -= skill;

                // If the monster's HP is less than or equal to 0, break.
                if (currentHp <= 0) {
                    break;
                }

                // Increment the number of skills required.
                skillsRequired++;
            }

            // Update the minimum number of skills if necessary.
            minSkills = Math.min(minSkills, skillsRequired);
        }

        // Return the minimum number of skills.
        return minSkills;
    }

    public static String[] solution1(String[] logs) {
        Map<String, Set<String>> users = new HashMap<>();
        for(String log : logs) {
            String[] temp = log.split(" ");
            String user = temp[0];
            String problem = temp[1];

            if(users.containsKey(user)) {
                users.get(user).add(problem);
            } else {
                Set<String> problemTemp = new HashSet<>();
                problemTemp.add(problem);
                users.put(user,problemTemp);
            }
        }

        Map<String, Integer> problemCnt = new HashMap<>();
        for(Set<String> problem : users.values()) {
            for(String p : problem) {
                problemCnt.put(p, problemCnt.getOrDefault(p,0) + 1 );
            }
        }

        List<String> wellKnownList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : problemCnt.entrySet()) {
            String problem = entry.getKey();
            int cnt = entry.getValue();
            int halfUserSize = users.size() / 2;

            if(users.size() % 2 != 0) {
                halfUserSize +=1 ;
            }

            if(cnt >= halfUserSize) {
                wellKnownList.add(problem);
            }
        }

        Collections.sort(wellKnownList);
        return wellKnownList.toArray(new String[wellKnownList.size()]);
    }
}
