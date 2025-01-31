package algo_programmers;

import java.util.*;

public class Lv2 {
    static boolean[][] sol2_visited;
    static int[] sol2_dirX = {0, 1, -1, 0};
    static int[] sol2_dirY = {1, 0, 0, -1};
    static int[][] sol2_dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우
    static int sol2_min = Integer.MAX_VALUE;

    public static void main(String[] args) {
//        solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2});

//        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
//        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
//        System.out.println(solution2(maps));

//        solution3("KAKAO");

//        solution4(2, 4, 2, 1);

        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        solution6(fees, records);

    }

    public static int[] solution6(int[] fees, String[] records) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        Map<String, Integer> carMap = new HashMap<>();
        Map<String, String> timeMap = new HashMap<>();

        for(String record : records) {
            String temp[] = record.split(" ");
            String time = temp[0];
            String number = temp[1];

            if(timeMap.containsKey(number)) {
                String[] timeTemp = timeMap.get(number).split(":");
                int inHH = Integer.parseInt(timeTemp[0]);
                int inMM = Integer.parseInt(timeTemp[1]);

                timeTemp = time.split(":");
                int outHH = Integer.parseInt(timeTemp[0]);
                int outMM = Integer.parseInt(timeTemp[1]);

                int carTime = (outHH - inHH) * 60 + (outMM - inMM);
                carMap.put(number, carMap.getOrDefault(number,0) + carTime);

                timeMap.remove(number);
                continue;
            }
            timeMap.put(number, time);
        }

        for(String key : timeMap.keySet()) {
            String[] timeTemp = timeMap.get(key).split(":");
            int inHH = Integer.parseInt(timeTemp[0]);
            int inMM = Integer.parseInt(timeTemp[1]);

            int carTime = (23 - inHH) * 60 + (59 - inMM);
            carMap.put(key, carMap.getOrDefault(key,0) + carTime);
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(carMap.entrySet());
        entryList.sort(Map.Entry.comparingByKey());

        int[] answer = new int[entryList.size()];
        for(int i = 0; i < entryList.size(); i++) {
            if(entryList.get(i).getValue() <= baseTime) {
                answer[i] = baseFee;
                continue;
            }

            int fee = baseFee + (int)Math.ceil((entryList.get(i).getValue() - baseTime) / (double) unitTime) * unitFee;
            answer[i] = fee;
        }

        return answer;
    }


    public static int[] solution5(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();


        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(numbers[i]);
        }

        return answer;
    }

    public static String solution4(int n, int t, int m, int p) {
        String answer = "";

        int num = 0;
        int cnt = 0;
        int order = p;
        StringBuilder sb = new StringBuilder();
        while(t > cnt) {
            sb.setLength(0);
            sb.append(Integer.toString(num,n).toUpperCase());
            for(int i = 0; i < sb.length(); i++) {
                if(order == 1) {
                    answer += sb.charAt(i);
                    order += m;
                    cnt++;
                }

                if(t < cnt) {
                    break;
                }
                order--;
            }
            num++;
        }

        return answer;
    }

    public static int[] solution3(String msg) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        int idx = 1;
        for(char ch = 'A'; ch <= 'Z'; ch++) {
            map.put(ch+"", idx);
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        int keyIndex = 0;
        boolean isEnd = false;
        for(int i = 0; i < msg.length(); i++) {
            sb.setLength(0);
            int j = i;
            sb.append(msg.charAt(i));
            while(map.containsKey(sb.toString())) {
                keyIndex = map.get(sb.toString());
                if(j == msg.length()-1) {
                    isEnd = true;
                    break;
                }
                sb.append(msg.charAt(++j));
            }

            map.put(sb.toString(), idx++);
            list.add(keyIndex);
            if(i < msg.length()-1) {
                i = j-1;
            }

            if(isEnd) {
                break;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int solution2(int[][] maps) {
        sol2_visited = new boolean[maps.length][maps[0].length];
//        sol2_dfs(0,0,maps,1);
//        return sol2_min == Integer.MAX_VALUE ? -1 : sol2_min;
        return sol2_bfs(maps.length, maps[0].length, maps);
    }

    public static int sol2_bfs(int n, int m, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        sol2_visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], distance = current[2];

            // 목적지 도달 시 최단 거리 반환
            if (x == n - 1 && y == m - 1) {
                return distance;
            }

            // 네 방향 탐색
            for (int[] dir : sol2_dir) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // 이동 가능 조건: 범위 내, 이동 가능(1)
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !sol2_visited[nx][ny] && maps[nx][ny] == 1) {
                    sol2_visited[nx][ny] = true; // 방문 처리 (다시 방문 방지)
                    queue.offer(new int[]{nx, ny, distance + 1});
                }
            }
        }
        return -1;
    }

    public static void sol2_dfs(int x, int y, int[][] maps, int sum) {
        if(sum >= sol2_min) return;

        if(x == maps.length-1 && y == maps[0].length-1) {
            sol2_min = Math.min(sol2_min, sum);
            return;
        }
        sol2_visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int dirX = x+sol2_dirX[i];
            int dirY = y+sol2_dirY[i];
            if(dirX >= 0 && dirY >= 0 && dirX < maps.length && dirY < maps[0].length && !sol2_visited[dirX][dirY] && maps[dirX][dirY] == 1) {
                sol2_dfs(dirX, dirY, maps, sum+1);
            }
        }
        sol2_visited[x][y] = false;
    }

    public static int solution(int[] topping) {
        int answer = 0;

        Map<Integer,Integer> firstMap = new HashMap<>();
        Map<Integer,Integer> tempMap = new HashMap<>();
        int firstCnt = 0;
        int tempCnt = 0;

        for(int i = 1; i < topping.length; i++) {
            if(!tempMap.containsKey(topping[i])) {
                tempCnt++;
            }
            tempMap.put(topping[i],tempMap.getOrDefault(topping[i],0) + 1);
        }

        for(int i = 0; i < topping.length-1; i++){
            if(!firstMap.containsKey(topping[i])) {
                firstMap.put(topping[i], 1);
                firstCnt++;
            }

            if(i > 0) {
                tempMap.put(topping[i], tempMap.get(topping[i])-1);
                if(tempMap.get(topping[i]) == 0) {
                    tempCnt--;
                }
            }
            if(firstCnt == tempCnt) {
                answer++;
            }
        }
        return answer;
    }
}
