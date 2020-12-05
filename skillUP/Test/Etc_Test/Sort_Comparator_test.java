package Etc_Test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Sort_Comparator_test {

    @Test
    public void comparingInt_sorting() {
        List<String> testList = Arrays.asList("A01", "A05", "A06", "A03");
        List<String> expectedList = Arrays.asList("A01", "A03", "A05", "A06");

        // 람다식을 이용한 버전
        testList.sort(Comparator.comparingInt((i) -> parseStringToNumber(i)));

        // 익명클래스 + 미리 만들어둔 메소드 활용
//        testList.sort(Comparator.comparingInt(new ToIntFunction<String>() {
//            @Override
//            public int applyAsInt(String value) {
//                return parseStringToNumber(value);
//            }
//        }));

        // 익명클래스 내부에 메소드 내용 구현
//        testList.sort(Comparator.comparingInt(new ToIntFunction<String>() {
//            @Override
//            public int applyAsInt(String value) {
//
//                String DIGIT_AND_DECIMAL_REGEX = "[^\\d.]";
//
//                final String digitsOnly = value.replaceAll(DIGIT_AND_DECIMAL_REGEX, "");
//
//                if("".equals(digitsOnly)) return 0;
//
//                try{
//                    return Integer.parseInt(digitsOnly);
//                }catch (NumberFormatException nfe){
//                    return 0;
//                }
//            }
//        }));
        assertEquals(expectedList, testList);
    }

    @Test
    public void sort를_통해_comparator_실전적용() {
        List<String> testList = Arrays.asList("1", "5", "6", "3");

        List<String> expectedList = Arrays.asList("1", "3", "5", "6");

        testList.sort((num1, num2) -> num1.compareTo(num2));

//        testList.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });

        assertEquals(expectedList, testList);
    }

    @Test
    public void 소팅기준이_널이어도_가능하다니() {
        List<String> testList = Arrays.asList("1", "5", "6", "3");
        List<String> testList2 = Arrays.asList("1", "5", "6", "3");

        List<String> expectedList = Arrays.asList("1", "3", "5", "6");

        testList.sort(null);
        Collections.sort(testList2);

        //assertEquals(expectedList, testList);
        assertEquals(testList2, testList);
    }

    @Test
    public void 알파벳_char_비교() {
        char a1 = 'A';
        char b1 = 'C';

        System.out.println(a1 < b1);

    }

    @Test
    public void 리스트테스트() {
        String a= "aa|bb|*";

        System.out.println(a.contains("*"));

    }

//    public Comparator<Boolean> createNaturalOrderRegexComparator() {
//
//        return Comparator.comparingInt(new ToIntFunction<Boolean>() {
//
//            return 0;
//        });
//    }

    private int parseStringToNumber(String input){

        String DIGIT_AND_DECIMAL_REGEX = "[^\\d.]";

        final String digitsOnly = input.replaceAll(DIGIT_AND_DECIMAL_REGEX, "");

        if("".equals(digitsOnly)) return 0;

        try{
            return Integer.parseInt(digitsOnly);
        }catch (NumberFormatException nfe){
            return 0;
        }
    }

}
