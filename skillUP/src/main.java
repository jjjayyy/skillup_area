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

//        String[] commands = {"prev", "next", "next"};
//        solution250507("10:55", "00:05", "00:15", "06:55", commands);

//        int[] wallet = {};
//        int[] bill = {};
//        solution250511(wallet, bill);

//        int[] bandage = {5,1,5};
//        int health = 30;
//        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
//        solution250511_2(bandage, health, attacks);

//        int[] diffs = {1,5,3};
//        int[] times = {2,4,7};
//        long limit = 30;
//        solution250511_4(diffs, times, limit);\

//        int[] schedules = {750};
//        int[][] timelogs = {{800,740,750}};
//        solution250512_1(schedules, timelogs, 1);

        solution250516_1(2, 1, 2);

    }

    public int[] solution250519_2(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        int zeroCnt = 0;

        while(s.length() > 1) {
            int len = s.length();
            int oneLen = s.replaceAll("0","").length();

            zeroCnt += len - oneLen;

            s = Integer.toBinaryString(oneLen);
            cnt++;
        }

        answer[0] = cnt;
        answer[1] = zeroCnt;
        return answer;
    }

    public String solution250519_1(String s)
    {
        StringBuilder sb = new StringBuilder(s.toLowerCase());

        boolean isFirst = true;
        for(int i = 0; i < sb.length(); i++) {
            if(isNumber250519_1(sb.charAt(i)+"")) {
                isFirst = false;
                continue;
            }

            if(sb.charAt(i) == ' ') {
                isFirst = true;
                continue;
            }

            if(isFirst) {
                sb.replace(i,i+1,String.valueOf(sb.charAt(i)).toUpperCase());
                isFirst = false;
            }
        }

        return sb.toString();
    }

    private boolean isNumber250519_1(String num) {
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean solution250518_1(String s) {
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            cnt = s.charAt(i) == '(' ? cnt+1 : cnt-1;
            if(cnt < 0) break;
        }
        return cnt == 0;
    }


    public String solution(String s) {
        String[] arr = s.split(" ");
        int max = Integer.MAX_VALUE * -1;
        int min = Integer.MAX_VALUE;
        for(String str : arr) {
            int num = Integer.parseInt(str);
            max = Math.max(max,num);
            min = Math.min(min,num);
        }

        return min + " " + max;
    }


    public int solution250517_1(int[][] info, int n, int m) {
        int answer = Integer.MAX_VALUE;

        int[][] dp = new int[info.length+1][m];

        for(int i = 0; i <= info.length; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        for(int i = 0; i < info.length; i++) {
            int a = info[i][0];
            int b = info[i][1];

            for(int j = 0; j < m; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;

                if(dp[i][j] + a < n) {
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + a);
                }

                if(j + b < m) {
                    dp[i+1][j+b] = Math.min(dp[i+1][j+b], dp[i][j]);
                }
            }
        }

        for(int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[info.length][i]);
        }


        return answer == Integer.MAX_VALUE ? -1 : answer    ;
    }


    public static int solution250516_1(int n, int w, int num) {
        int answer = 0;
        int n1 = n / w;
        int n2 = n % w;

        int num1 = num / w;
        int num2 = num % w;

        if(w > 1 && n1 % 2 == num1 % 2 && n2 >= num2) {
            answer += 1;
        }

        if(w > 1 && n1 % 2 != num1 % 2 && w-n2 < num2) {
            answer += 1;
        }

        if(num % w > 0) {
            num1 += 1;
        }

        answer += n1+1 - num1;

        return answer;
    }


    public static int solution250513_1(int[] mats, String[][] park) {
        int[] sorted = Arrays.stream(mats)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        for(int size : sorted) {
            for(int i = 0; i <= park.length-size; i++) {
                for(int j = 0; j <= park[0].length-size; j++) {
                    if (canPlace(park, i, j, size)) {
                        return size;
                    }
                }
            }
        }

        return -1;
    }

    private static boolean canPlace(String[][] park, int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false; // 사람이 있음
                }
            }
        }
        return true;
    }

    public static int solution250512_1(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for(int i = 0; i < timelogs.length; i++) {
            int innerStartday = startday-1;
            boolean isPass = true;

            int mm = schedules[i] % 100 + 10;
            int hh = schedules[i] / 100 + (mm / 60);
            int time = hh*100 + mm%60;
            for(int j = 0; j < timelogs[i].length; j++) {
                innerStartday++;
                if(innerStartday > 7) {
                    innerStartday = 1;
                }

                if(innerStartday > 5) {
                    continue;
                }

                if(time < timelogs[i][j]) {
                    isPass = false;
                    break;
                }
            }
            if(isPass) {
                answer++;
            }
        }
        return answer;
    }

    public static int solution250511_4(int[] diffs, int[] times, long limit) {

        int mid = 0;
        int max = 100000;
        int min = 1;
        while(min <= max) {
            mid = (max+min) / 2;
            long time = 0;
            for(int i = 0; i < diffs.length; i++) {
                time += times[i];
                if(diffs[i] > mid) {
                    time += (times[i] + times[i-1]) * (diffs[i] - mid);
                }
                if(limit < time) {
                    break;
                }
            }

            if(limit < time) {
                min = mid+1;
            } else {
                max = mid-1;
            }
        }
        return min;
    }

//    public int[][] solution250511_3(int[][] data, String ext, int val_ext, String sort_by) {
//        String[] arr = {"code","date","maximum","remain"};
//        List<String> columnList = Arrays.asList(arr);
//        int extIdx = columnList.indexOf(ext);
//        int sortIdx = columnList.indexOf(sort_by);
//        int[][] answer = Arrays.stream(data)
//                .filter(o1 -> o1[extIdx] < val_ext)
//                .sorted((o1 ,o2) -> o1[sortIdx]-o2[sortIdx])
//                .toArray(int[][]::new);
//
//        return answer;


//        Map<String,Integer> colMap = new HashMap<>();
//        colMap.put("code",0);
//        colMap.put("date",1);
//        colMap.put("maximum",2);
//        colMap.put("remain",3);
//        colMap.get(ext);
//
//        List<int[]> list = new ArrayList<>();
//        for(int i = 0; i < data.length; i++) {
//            if(val_ext > data[i][colMap.get(ext)]) {
//                list.add(data[i]);
//            }
//        }
//
//        list.sort(Comparator.comparing(newData -> newData[colMap.get(sort_by)]));
//
//        return list.toArray(new int[0][]);
//    }

    public static int solution250511_2(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int maxHP = health;

        for(int i = 0; i < attacks.length; i++) {
            if(i > 0) {
                int healSec = attacks[i][0]-1 - attacks[i-1][0];
                health += healSec * bandage[1] + healSec/bandage[0] * bandage[2];
                if(health > maxHP) {
                    health = maxHP;
                }
            }

            health -= attacks[i][1];

            if(health <= 0) {
                answer = -1;
                break;
            }

            answer = health;
        }

        return answer;
    }

    public static int solution250511(int[] wallet, int[] bill) {
        int answer = 0;

        int minBill = Math.min(bill[0],bill[1]);
        int maxBill = Math.max(bill[0],bill[1]);
        int minWallet = Math.min(wallet[0],wallet[1]);
        int maxWallet = Math.max(wallet[0],wallet[1]);

        while(minBill > minWallet || maxBill > maxWallet) {
            if(bill[0] > bill[1]) {
                bill[0]/=2;
            } else {
                bill[1]/=2;
            }
            answer++;

            minBill = Math.min(bill[0],bill[1]);
            maxBill = Math.max(bill[0],bill[1]);
        }

        return answer;
    }


    public static String solution250507(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenSec = solution250507_toSec(video_len);
        int posSec = solution250507_toSec(pos);
        int opStartSec = solution250507_toSec(op_start);
        int opEndSec = solution250507_toSec(op_end);

        if(opStartSec <= posSec && opEndSec >= posSec) {
            posSec = opEndSec;
        }

        for(String command : commands) {
            int sec = command.equals("prev") ? -10 : 10;
            posSec += sec;

            if(posSec < 0) {
                posSec = 0;
            }

            if(videoLenSec < posSec) {
                posSec = videoLenSec;
            }

            if(opStartSec <= posSec && opEndSec >= posSec) {
                posSec = opEndSec;
            }
        }

        int mm = posSec / 60;
        int ss = posSec % 60;

        System.out.println(mm + ":" + ss);

        return String.format("%02d:%02d", mm, ss);
    }

    public static int solution250507_toSec(String time) {
        String[] timeString = time.split(":");
        int mm = Integer.parseInt(timeString[0]);
        int ss = Integer.parseInt(timeString[1]);

        return mm * 60 + ss;
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