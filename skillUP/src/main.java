import java.util.*;

public class main {

    static List<String> parenthesisList = new ArrayList<>();
    public static void main(String[] args) {
//        int[] g = {262,437,433,102,438,346,131,160,281,34,219,373,466,275,51,118,209,32,108,57,385,514,439,73,271,442,366,515,284,425,491,466,322,34,484,231,450,355,106,279,496,312,96,461,446,422,143,98,444,461,142,234,416,45,271,344,446,364,216,16,431,370,120,463,377,106,113,406,406,481,304,41,2,174,81,220,158,104,119,95,479,323,145,205,218,482,345,324,253,368,214,379,343,375,134,145,268,56,206};
//        int[] s = {149,79,388,251,417,82,233,377,95,309,418,400,501,349,348,400,461,495,104,330,155,483,334,436,512,232,511,40,343,334,307,56,164,276,399,337,59,440,3,458,417,291,354,419,516,4,370,106,469,254,274,163,345,513,130,292,330,198,142,95,18,295,126,131,339,171,347,199,244,428,383,43,315,353,91,289,466,178,425,112,420,85,159,360,241,300,295,285,310,76,69,297,155,416,333,416,226,262,63,445,77,151,368,406,171,13,198,30,446,142,329,245,505,238,352,113,485,296,337,507,91,437,366,511,414,46,78,399,283,106,202,494,380,479,522,479,438,21,130,293,422,440,71,321,446,358,39,447,427,6,33,429,324,76,396,444,519,159,45,403,243,251,373,251,23,140,7,356,194,499,276,251,311,10,147,30,276,430,151,519,36,354,162,451,524,312,447,77,170,428,23,283,249,466,39,58,424,68,481,2,173,179,382,334,430,84,151,293,95,522,358,505,63,524,143,119,325,401,6,361,284,418,169,256,221,330,23,72,185,376,515,84,319,27,66,497};

//        findContentChildren(g, s);
//        licenseKeyFormatting("2", 2);
//        constructRectangle(122122);
//        reverseStr("abcdefg", 4);
//        intToRoman(20);
        generateParenthesis(3);
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