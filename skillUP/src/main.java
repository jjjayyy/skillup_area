import java.util.*;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
//        int[] g = {262,437,433,102,438,346,131,160,281,34,219,373,466,275,51,118,209,32,108,57,385,514,439,73,271,442,366,515,284,425,491,466,322,34,484,231,450,355,106,279,496,312,96,461,446,422,143,98,444,461,142,234,416,45,271,344,446,364,216,16,431,370,120,463,377,106,113,406,406,481,304,41,2,174,81,220,158,104,119,95,479,323,145,205,218,482,345,324,253,368,214,379,343,375,134,145,268,56,206};
//        int[] s = {149,79,388,251,417,82,233,377,95,309,418,400,501,349,348,400,461,495,104,330,155,483,334,436,512,232,511,40,343,334,307,56,164,276,399,337,59,440,3,458,417,291,354,419,516,4,370,106,469,254,274,163,345,513,130,292,330,198,142,95,18,295,126,131,339,171,347,199,244,428,383,43,315,353,91,289,466,178,425,112,420,85,159,360,241,300,295,285,310,76,69,297,155,416,333,416,226,262,63,445,77,151,368,406,171,13,198,30,446,142,329,245,505,238,352,113,485,296,337,507,91,437,366,511,414,46,78,399,283,106,202,494,380,479,522,479,438,21,130,293,422,440,71,321,446,358,39,447,427,6,33,429,324,76,396,444,519,159,45,403,243,251,373,251,23,140,7,356,194,499,276,251,311,10,147,30,276,430,151,519,36,354,162,451,524,312,447,77,170,428,23,283,249,466,39,58,424,68,481,2,173,179,382,334,430,84,151,293,95,522,358,505,63,524,143,119,325,401,6,361,284,418,169,256,221,330,23,72,185,376,515,84,319,27,66,497};

//        findContentChildren(g, s);
//        licenseKeyFormatting("2", 2);
//        constructRectangle(122122);
//        reverseStr("abcdefg", 4);
//        intToRoman(20);
//        generateParenthesis(3);
//        int[] nums = {1,2,3};
//        permute(nums);

//        int[] time = {1,4};
//        int d = 2;
//        findPoisonedDuration(time, 2);

//        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
//        islandPerimeter(grid);

//        String[] op = {"5","2","C","D","+"};
//        System.out.println(calPoints(op));

//        int[] nums1 = {4,1,2};
//        int[] nums2 = {1,3,4,2};
//        nextGreaterElement(nums1, nums2);

//        int[] nums = {1,4,3,2};
//        arrayPairSum(nums);

//        selfDividingNumbers(21, 22);

//        int[] candyType = {1,1,2,3};
//        System.out.println(distributeCandies(candyType));

//        int[] nums = {-1,-3,-2,-4};
//        maximumProduct(nums);

//        int[][] img = {{100,200,100},{200,50,200},{100,200,100}};
//        imageSmoother(img);

//        largeGroupPositions("aaa");

//        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
//        flipAndInvertImage(image);

//        test();

//        String aa = "3142592".substring(2,3);
//        System.out.println(aa);
//        solution("10203", "15");

//        String[] cards1 = {"i", "water", "drink"};
//        String[] cards2 = {"want", "to"};
//        String[] goals = {"i", "want", "to", "drink", "water"};
//        System.out.println(solution(cards1, cards2, goals));

//        solution("10203", "15");

//        String[] keymap = {"AA"};
//        String[] targets = {"B"};
//        solution3(keymap, targets);

//        int[] number = {-3, -2, -1, 0, 1, 2, 3};
//        System.out.println(solution4(number));

//        int[] score = {10, 0, 0, 0, 0, 0, 0};
//        solution5(2,score);

//        int[] section = {2, 3, 6};
//        solution6(8,4,section);

//        String[] name = {"may", "kein", "kain", "radi"};
//        int[] yearning = {5, 10, 1, 3};
//        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
//        solution7(name, yearning, photo);

//        solution8("aabba");

//        int[] food = {1, 3, 4, 6};
//        System.out.println(solution9(food));

//        solution9(8, 4, 7);

//        solution10(4);

//        solution11(3,1,20);

//        int[] elements = {7,9,1,1,4};
//        solution13(elements);

//        solution16("abracadabra");

//        solution17("z", "a", 1);

//        solution18("12321", "42531");

        solution19("[)(]");
    }

    private static boolean isBracket_sol19(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
                continue;
            }

            if(stack.empty()) {
                return false;
            }

            switch(s.charAt(i)) {
                case ']' :
                    if(stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(s.charAt(i));
                    }
                        break;
                case ')' :
                    if(stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(s.charAt(i));
                    }
                    break;
                case '}' :
                    if(stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.push(s.charAt(i));
                    }
                    break;
            }
        }
        return stack.empty() ? true : false;
    }

    private static String rotateStr_sol19(String s) {
        return s.substring(1) + s.charAt(0);
    }

    public static int solution19(String s) {
        int answer = 0;

        for(int i = 0; i < s.length(); i++) {
            if(i > 0) {
                s = rotateStr_sol19(s);
            }
            if(isBracket_sol19(s)) {
                answer++;
            };
        }

        return answer;
    }

    public static String solution18(String X, String Y) {
        int[] xArr = new int[10];
        int[] yArr = new int[10];

        for(int i = 0; i < X.length(); i++) {
            xArr[Integer.parseInt(X.charAt(i)+"")]++;
        }

        for(int i = 0; i < Y.length(); i++) {
            yArr[Integer.parseInt(Y.charAt(i)+"")]++;
        }

        int[] temp = new int[10];
        for(int i = 0; i < temp.length; i++) {
            while(xArr[i] > 0 && yArr[i] > 0) {
                temp[i]++;
                xArr[i]--;
                yArr[i]--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            while(temp[i] > 0) {
                sb.append(i);
                temp[i]--;
            }
        }

        if(sb.length() == 0) {
            return "-1";
        }

        return sb.charAt(0) == '0' ? sb.toString().replaceAll("0+","0") : sb.toString();
    }

    public static String solution17(String s, String skip, int index) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < index; j++) {
                c += 1;
                if (c > 'z') {
                    c -= 26;
                }
                if (skip.contains(String.valueOf(c))) {
                    j--;
                }
            }
            answer += c;
        }
        return answer;
    }

    private static int cnt = 0;
    public static int solution(int k, int[][] dungeons) {

        boolean[] visited = new boolean[dungeons.length];
        dfs_sol17(k,dungeons,visited);

        return cnt;
    }

    private static void dfs_sol17(int k, int[][] dungeons, boolean[] visited) {
        int count = 0;
        for(boolean visit : visited) {
            if(visit) count++;
        }
        cnt = Math.max(count, cnt);

        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs_sol17(k-dungeons[i][1], dungeons, visited);
                visited[i] = false;
            }
        }
    }

    public static int solution16(String s) {
        int answer = 0;
        char startC = ' ';
        int startCnt = 0;
        int otherCnt = 0;
        for(int i = 0; i < s.length(); i++) {
            if(startCnt == 0) {
                startC = s.charAt(i);
                startCnt++;
                continue;
            }

            if(startC == s.charAt(i)) {
                startCnt++;
            } else {
                otherCnt++;
            }

            if(startCnt == otherCnt) {
                answer++;
                startCnt = 0;
                otherCnt = 0;
            }
        }

        if(startCnt > 0) {
            answer++;
        }

        return answer;
    }

    public int solution15(String[] babbling) {
        int answer = 0;

        for(String babb : babbling) {
            babb = babb.replaceAll("ayaaya|yeye|woowoo|mama", " ");
            babb = babb.replaceAll("aya|ye|woo|ma", "");
            if(babb.length() == 0) {
                answer++;
            }
        }

        return answer;
    }


    public static int solution14(int number, int limit, int power) {
        int answer = 0;
        int[] arr = new int[number];

        for(int i = 1; i <= number; i++) {
            int cnt = 0;
            for(int j = 1; j * j <= i; j++) {
                if(i % j == 0) {
                    cnt++;
                    if(j != i/j) {
                        cnt++;
                    }
                }
            }
            arr[i-1] = cnt;
        }

        for(int num : arr) {
            if(num > limit) {
                answer += power;
                continue;
            }
            answer += num;
        }

        return answer;
    }

    public static int solution13(int[] elements) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < elements.length; i++) {
            int sum = elements[i];
            set.add(sum);

            for(int j = 0; j < elements.length; j++) {
                if(i == j) continue;
                sum += elements[j];
                set.add(sum);
            }

//            for(int j = i+1; j < i+elements.length; j++) {
//                sum += elements[j%elements.length];
//                set.add(sum);
//            }
        }
        return set.size();
    }

    public static int solution12(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer,Integer> map = new HashMap<>();
        for(int num : tangerine) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        // HashMap의 키-값 쌍을 리스트로 변환
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        // 리스트를 값에 따라 정렬 (예: 값이 작은 순서로 정렬)
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for(Map.Entry<Integer,Integer> numMap : list) {
            if(k <= 0) break;
            k -= numMap.getValue();
            answer++;
        }

        return answer;
    }

    public static int solution11(int a, int b, int n) {
        int answer = 0;

        while(n >= a) {
            int temp = n % a;
            answer += (n/a) * b;
            n = (n/a) * b + temp;
        }

        return answer;
    }

    public static long solution10(int n) {

        if(n < 3) {
            return n;
        }
        long[] nArr = new long[n+1];
        for(long i = 0; i < 3; i++) {
            nArr[(int) i] = i;
        }

        for(int i = 3; i <= n; i++) {
            nArr[i] = (nArr[i-1] + nArr[i-2]) % 1234567;
        }
        return nArr[n];
    }

    public static int solution9(int n, int a, int b)
    {
        int answer = 1;

        if(Math.max(a,b) % 2 == 0 && Math.abs(a - b) == 1) {
            return answer;
        }
        while(!(Math.max(a,b) % 2 == 0 && Math.abs(a - b) == 1)) {
            if(a % 2 == 1) {
                a += 1;
            }
            if(b % 2 == 1) {
                b += 1;
            }
            a /= 2;
            b /= 2;
            answer++;
        }
        return answer;
    }

    public static String solution9(int[] food) {
        StringBuilder builder = new StringBuilder();
        for(int i = 1; i < food.length; i++) {
            if(food[i] == 1) {
                continue;
            }

            for(int j = 0; j < food[i]/2; j++) {
                builder.append(i);
            }
        }
        String result = builder.toString();
        return result + "0" + builder.reverse().toString();
    }

    public static int[] solution8(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();

        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c,-1);
        }

        for(int i = 0; i < s.length(); i++) {
            int temp = map.get(s.charAt(i));

            if(temp >= 0) {
                temp = i - temp;
            }

            answer[i] = temp;
            map.put(s.charAt(i), i);
        }
        return answer;
    }

    public static int[] solution7(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < name.length; i++) {
            map.put(name[i],yearning[i]);
        }

        for(int i = 0; i < photo.length; i++) {
            int sum = 0;
            for(String pName : photo[i]) {
                sum += map.getOrDefault(pName,0);
            }
            answer[i] = sum;
        }

        return answer;
    }

    public static int solution6(int n, int m, int[] section) {
        int answer = 0;
        int temp = 0;

        for(int i = 0; i < section.length; i++) {
            if(temp < section[i]) {
                temp = section[i]+(m-1);
                answer++;
            }
        }

        return answer;
    }

    public static int[] solution5(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i < score.length; i++) {
            queue.add(score[i]);
            if (queue.size() > k) {
                queue.poll();
            }
            answer[i] = queue.peek();
        }
        return answer;
    }

    public static int solution4(int[] number) {
        int[] temp = {0};
        for(int i = 0; i < number.length; i++) {
            dfs(number, i, 1, number[i], temp);
        }
        return temp[0];
    }

    private static void dfs(int[] number, int idx, int cnt, int sum, int[] temp) {
        if(cnt == 3) {
            if(sum == 0) {
                temp[0]++;
            }
            return;
        }

        for(int i = idx+1; i < number.length; i++) {
            int sum_dfs = sum;
            sum_dfs += number[i];
            dfs(number, i, cnt+1, sum_dfs, temp);
        }
    }

    public static int[] solution3(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for(int i = 0; i < targets.length; i++) {
            int sum = 0;
            for(int j = 0; j < targets[i].length(); j++) {
                int min = Integer.MAX_VALUE;
                boolean isContain = false;

                char alphabet = targets[i].charAt(j);
                for(String key : keymap) {
                    isContain = isContain ? true : key.contains(alphabet + "" );

                    int idx = key.indexOf(alphabet);
                    if(idx != -1) {
                        min = Math.min(min, key.indexOf(alphabet) + 1);
                    }
                }
                sum += min;
                if(!isContain) {
                    sum = -1;
                    break;
                }
            }
            answer[i] = sum;
        }
        return answer;
    }


    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.parallelSort(score);
        int cnt = 0;
        for(int i = score.length-1; i >= 0; i--) {
            cnt++;
            if(cnt == m) {
                answer += score[i] * m;
                cnt = 0;
            }
        }
        return answer;
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";

//        Queue<String> qCards1 = new LinkedList<>();
//        Queue<String> qCards2 = new LinkedList<>();
//
//        for (String card : cards1) {
//            qCards1.offer(card); // 큐에 요소 추가
//        }
//
//        for (String card : cards2) {
//            qCards2.offer(card); // 큐에 요소 추가
//        }

        int cards1Idx = 0;
        int cards2Idx = 0;

        for(String word : goal) {
            if(cards1.length > cards1Idx && word.equals(cards1[cards1Idx])) {
                cards1Idx++;
                continue;
            }

            if(cards2.length > cards2Idx && word.equals(cards2[cards2Idx])) {
                cards2Idx++;
                continue;
            }
            return "No";
        }
        return "Yes";
    }

    public static int solution(String t, String p) {
        int answer = 0;

        long pNum = Long.parseLong(p);

        for(int i = 0; i < t.length(); i++) {

            if(i+p.length() > t.length()) break;
            long tSliceNum = Long.parseLong(t.substring(i, i+p.length()));

            if(pNum >= tSliceNum) {
                answer++;
            }
        }
        return answer;
    }

    public static void test() {
        int[] nums = {};
        int[] temp = nums.clone();
        int[] result = new int[temp.length+1];

        System.out.println(result.length);
    }

    public static int[][] flipAndInvertImage(int[][] image) {

        int n = image.length;
        int[][] result = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int num = image[i][j] == 0 ? 1 : 0;
                result[i][n-j-1] = num;
            }
        }

        return result;
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> resultList = new ArrayList<>();

        s = s + ' ';
        char temp = ' ';
        int startIdx = 0;
        int cnt = 1;
        for(int i = 0; i < s.length(); i++){
            if(temp == s.charAt(i)) {
                cnt++;
                continue;
            }

            if(cnt >= 3) {
                List<Integer> innerList = new ArrayList<>();
                innerList.add(startIdx);
                innerList.add(i-1);
                resultList.add(innerList);
            }

            temp = s.charAt(i);
            startIdx = i;
            cnt = 1;
        }

        return resultList;
}

    public static int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] newImg = new int[m][n];

        int cnt = 0;
        int sum = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                cnt = 0;
                sum = 0;
                for(int k = -1; k <= 1; k++) {
                    for(int o = -1; o <= 1; o++) {
                        if(i+k < 0 || j+o < 0 ||
                                i+k >= img.length || j+o >= img[0].length) {
                            continue;
                        }
                        sum += img[i+k][j+o];
                        cnt++;
                    }
                }
                newImg[i][j] = sum / cnt;
            }
        }
        return newImg;
    }


    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        int max1 = nums[n] * nums[n-1] * nums[n-2];
        int max2 = nums[0] * nums[1] * nums[n];

        return Math.max(max1, max2);
    }

    public static int distributeCandies(int[] candyType) {
        int cnt = candyType.length / 2;
        int result = 0;

        long candyTypeCnt = Arrays.stream(candyType)
                .boxed()
                .distinct()
                .count();

        if(candyTypeCnt < cnt) {
            return (int) candyTypeCnt;
        }

        return cnt;
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();

        for(int i = left; i <= right; i++) {
            int temp = i;
            boolean isDivided = true;

            while(temp != 0) {
                if(temp % 10 == 0 || i % (temp % 10) != 0) {
                    isDivided = false;
                    break;
                }
                temp /= 10;
            }

            if(isDivided) list.add(i);
        }

        return list;
    }

    public static int arrayPairSum(int[] nums) {
        int maxSum = 0;

        String s = "";
        s.toLowerCase();

        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(numList);

        for(int i = 0; i < numList.size(); i+=2) {
            maxSum += numList.get(i);
        }

        System.out.println(maxSum);
        return maxSum;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        boolean isSameNum;
        int[] resultArr = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++) {
            resultArr[i] = -1;
            isSameNum = false;
            for(int num2 : nums2) {
                if(nums1[i] == num2) {
                    isSameNum = true;
                }
                if(isSameNum && nums1[i] < num2) {
                    resultArr[i] = num2;
                    break;
                }
            }
        }
        return resultArr;
    }

    public static int calPoints(String[] operations) {
        List<Integer> resultList = new ArrayList<>();
        int temp = 0;
        for(String opr : operations) {
            if(opr.equals("+")) {
                temp = resultList.get(resultList.size()-1) + resultList.get(resultList.size()-2);
                resultList.add(temp);
                continue;
            }
            if(opr.equals("D")) {
                temp = resultList.get(resultList.size()-1) * 2;
                resultList.add(temp);
                continue;
            }
            if(opr.equals("C")) {
                resultList.remove(resultList.size()-1);
                continue;
            }
            resultList.add(Integer.parseInt(opr));
        }
        return resultList.stream()
                .mapToInt(x -> x)
                .sum();
    }

    public static boolean judgeCircle(String moves) {
        int[] start = {0,0};
        for(int i = 0; i < moves.length(); i++) {
            switch(moves.charAt(i)) {
                case 'U': start[0] += 1; break;
                case 'D': start[0] -= 1; break;
                case 'L': start[1] -= 1; break;
                case 'R': start[1] += 1; break;
            }
        }
        return start[0] == 0 && start[1] == 0;
    }

    public static int islandPerimeter(int[][] grid) {
        int width = grid.length;
        int height = grid[0].length;
        int result = 0;

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                if(grid[i][j] == 1) {
                    result += 4;
                    if(i > 0 && grid[i-1][j] == 1) {
                        result -= 2;
                    }
                    if(j > 0 && grid[i][j-1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int index = 0;
        int cnt = 0;
        while(timeSeries.length > index) {
            for(int i = 0; i < duration; i++) {
                if(index+1 < timeSeries.length && timeSeries[index]+i == timeSeries[index+1]) {
                    break;
                }
                cnt++;
            }
            index++;
        }
        System.out.println(cnt);
        return cnt;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutations(result, new ArrayList<>(), nums);
        return result;
    }

    private static void permutations(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            permutations(result, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public static void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public static boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }


    public static String intToRoman(int num) {
        Map<String,Integer> romanMap = new LinkedHashMap<>();
        romanMap.put("M",1000);
        romanMap.put("CM",900);
        romanMap.put("D",500);
        romanMap.put("CD",400);
        romanMap.put("C",100);
        romanMap.put("XC",90);
        romanMap.put("L",50);
        romanMap.put("XL",40);
        romanMap.put("X",10);
        romanMap.put("IX",9);
        romanMap.put("V",5);
        romanMap.put("IV",4);
        romanMap.put("I",1);

        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            for(String key : romanMap.keySet()) {
                if(num >= romanMap.get(key)) {
                    sb.append(key);
                    num -= romanMap.get(key);
                    break;
                }
            }
        }


        System.out.println(sb.toString());
        return sb.toString();
    }

    public static String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }


    public static int[] constructRectangle(int area) {
        int[] result = {0,0};
        int min = Integer.MAX_VALUE;

        for(int l = area; l >= (int) Math.sqrt(area); l--) {
            int w = area / l;
            if(area % l == 0 && l - w >= 0 && l - w < min) {
                min = l - w;
                result[0] = l;
                result[1] = w;
            }
        }
        return result;
    }


    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        s = s.replace("-","");
        int remainder = s.length() % k;

        for(int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));

            if(i < s.length()-1) {
                if(remainder > 0 && i+1 == remainder) sb.append("-");
                if((i+1 > remainder ? i+1-remainder : i+1) % k == 0) sb.append("-");
            }
        }

        System.out.println(sb.toString());
        return sb.toString().toUpperCase();
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int tempIdx = 0;
        int result = 0;
        for(int i = 0; i < g.length; i++) {
            for(int j = tempIdx; j < s.length; j++) {
                if(g[i] <= s[j]) {
                    result++;
                    tempIdx = j+1;
                    break;
                }
            }
        }
        System.out.println(result);
        return result;
    }
}