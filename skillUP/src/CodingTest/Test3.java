package CodingTest;

public class Test3 {

    public static String newPassword(String a, String b) {
        // Write your code here
        StringBuilder sb = new StringBuilder();

        int maxLength = a.length();
        boolean isLargerA = true;       //a is larger than b

        if(a.length() < b.length()) {
            maxLength = b.length();
            isLargerA = false;            //b is larger than a
        }

        for(int i = 0; i < maxLength; i++) {
            if(isLargerA) {
                sb.append(a.charAt(i));
                if(b.length() > i) {
                    sb.append(b.charAt(i));
                }
            } else {
                if(a.length() > i) {
                    sb.append(a.charAt(i));
                }
                sb.append(b.charAt(i));
            }

        }

        return sb.toString();

    }

    public static String newPassword2(String a, String b) {

        // Write your code here
        StringBuilder sb = new StringBuilder();

        int minLength = b.length();
        int gap = a.length() - b.length();
        boolean isLargerA = true;       //a is larger than b

        if(a.length() < b.length()) {
            minLength = a.length();
            gap = b.length() - a.length();
            isLargerA = false;            //b is larger than a
        }

        for(int i = 0; i < minLength; i++) {
            sb.append(a.charAt(i));
            sb.append(b.charAt(i));
        }

        for(int i = 0; i < gap; i++) {
            if(isLargerA) {
                sb.append(a.charAt(i));
            } else {
                sb.append(b.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(newPassword2("ab", "zsd"));
    }
}

