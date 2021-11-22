package CodingTest;

import java.util.HashMap;
import java.util.Map;
public class NF_Test3 implements Bank {

    public static void main(String[] args) {
        Bank bank = new NF_Test3();
        System.out.println(bank.getAccount(23));
        System.out.println(bank.findDormancyAccount());
    }

    public String[] solution(String[] logs) {
        String[] answer = {};
        Map<String, Map<String, Integer>> map = new HashMap<>();
        Map<String, Integer> inner_map = new HashMap<>();


        return answer;
    }

    @Override
    public String getAccount(int price) {
        return "인터페이스 어카운트";
    }

    public String findDormancyAccount() {
        return "인터페이스 어어어카우늩";
    }
}
