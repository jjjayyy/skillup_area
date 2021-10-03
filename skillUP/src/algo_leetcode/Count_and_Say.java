package algo_leetcode;

public class Count_and_Say {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        if(n == 1) return "1";
        String str = countAndSay(n-1);

        int cnt = 1;
        char temp = str.charAt(0);
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);

            if(temp == c) {
                cnt++;
                continue;
            }

            sb.append(cnt).append(temp);
            temp = c;
            cnt = 1;
        }
        sb.append(cnt).append(temp);
        return sb.toString();
    }
}
