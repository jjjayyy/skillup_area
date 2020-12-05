package CodingTest;



public class Test1_2020 {

    public static void main(String[] args) {

        //String new_id = "...!@BaT#*..y.abcdefghijklm";
        String new_id = "z-+.^.";
        System.out.println(solution(new_id));

        //System.out.println(new_id.replaceAll("^\\.|\\.$", ""));
    }

    public static String solution(String new_id) {
        String answer =  new_id.toLowerCase();      //Step1 : 대문자 -> 소문자

        String step2_pattern = "[\\W&&[^-_.]]"; //Step2 : 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거

        String step3_pattern = "\\.+\\.";  //Step3 : 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환

        String step4_pattern = "^\\.|\\.$";  //Step4 : 마침표(.)가 처음이나 끝에 위치한다면 제거

        answer = answer.replaceAll(step2_pattern, "")
                       .replaceAll(step3_pattern, ".")
                       .replaceAll(step4_pattern, "");

        //Step5 : 빈 문자열이라면, new_id에 "a"를 대입
        if(answer == null || answer.isEmpty()) {
            answer = "a";
        }

        //Step6
        if(answer.length() > 15) {
            answer = answer.substring(0, 15).replaceAll(step4_pattern, "");
        }

        //Step7
        if(answer.length() <= 2) {
            int length = answer.length();
            for(int i = 0; i < 3 -length; i++) {
                answer += answer.charAt(length - 1);
            }
        }

        return answer;
    }
}
