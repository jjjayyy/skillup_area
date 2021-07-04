package CodingTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NWT_Test1 {

    public static void main(String[] args) {
        int[] prices = {100000, 100000, 100000};
        int[] discounts = {50, 50};
        System.out.println(solution(prices, discounts));
    }

    public static int solution(int[] prices, int[] discounts) {
        List<Integer> priceList = Arrays.stream(prices).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        List<Integer> discountList = Arrays.stream(discounts).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        int sum = 0;
        for(int i = 0; i < priceList.size(); i++) {
            if(i < discountList.size()) {
                sum += priceList.get(i) * (100 - discountList.get(i)) / 100;
            } else {
                sum += priceList.get(i);
            }
        }
        return sum;
    }
}
