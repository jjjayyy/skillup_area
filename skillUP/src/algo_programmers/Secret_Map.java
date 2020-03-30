package algo_programmers;

public class Secret_Map {

    public String[] solution(int n, int[] arr1, int[] arr2) {

        String binaryStr1;
        String binaryStr2;
        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();

        String binaryFormat = String.valueOf(n);

        for(int i = 0; i < n; i++) {
            sb.setLength(0);

            binaryStr1 = String.format("%" + binaryFormat + "s", Integer.toBinaryString(arr1[i])).replace(' ', '0');
            binaryStr2 = String.format("%" + binaryFormat + "s", Integer.toBinaryString(arr2[i])).replace(' ', '0');

            for(int j = 0; j < n; j++) {
                if(binaryStr1.charAt(j) == '1' || binaryStr2.charAt(j) == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }


    public static void main(String[] args) {
        int num = 9;
        int n = 5;
        int num2 = 5;

        String b = "5";
//        System.out.println(2|4);

        String temp = Integer.toBinaryString(num|num2);
//        System.out.println(Integer.toBinaryString(num));
//        System.out.println(Integer.toBinaryString(num2));
//        System.out.println(temp);

        String tt = String.format("%" + 5 + "s", temp);

        System.out.println(tt);
        System.out.println(tt.replaceAll("1", "#").replaceAll("0", " "));

        String a2 = String.format("%" + b + "s", Integer.toBinaryString(num));




        System.out.println(a2.replace(' ', '0'));
    }
}
