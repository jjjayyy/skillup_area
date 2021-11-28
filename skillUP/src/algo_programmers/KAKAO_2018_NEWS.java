package algo_programmers;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KAKAO_2018_NEWS {

    public static void main(String[] args) {

        System.out.println(Character.MAX_VALUE + 1);

        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }

    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for(int i = 2; i <= str1.length(); i++) {
            String temp = str1.substring(i-2, i);
            if(!Pattern.matches("^[A-Z]*$", temp)) {
                continue;
            }
            list1.add(str1.substring(i-2, i));
        }

        for(int i = 2; i <= str2.length(); i++) {
            String temp = str2.substring(i-2, i);
            if(!Pattern.matches("^[A-Z]*$", temp)) {
                continue;
            }
            list2.add(str2.substring(i-2, i));
        }

        if(list1.isEmpty() && list2.isEmpty()) {
            return 65536;
        }

        Collections.sort(list1);
        Collections.sort(list2);

        double interCnt = 0;
        for(int i = 0; i < list1.size(); i++) {
            if(list2.contains(list1.get(i))) {
                interCnt++;
                list2.remove(list1.get(i));
            }
        }

        double unionCnt = list1.size() + list2.size();
        double jaccard = interCnt / unionCnt;

        return (int) (jaccard * 65536);
    }



    private static final Integer MULTIPLIER = Character.MAX_VALUE + 1;

    public int solution2(String str1, String str2) {
        String word1 = str1.toLowerCase();
        String word2 = str2.toLowerCase();

        Map<String, Long> words1 = group(word1);
        Map<String, Long> words2 = group(word2);

        Integer intersection = getIntersection(words1, words2);
        Integer union = getUnion(words1, words2);

        if (intersection.equals(union) && union.equals(0)) {
            return MULTIPLIER;
        }

        return (int) (intersection.doubleValue() / union.doubleValue() * MULTIPLIER);
    }

        private Map<String, Long> group(String word) {
        return IntStream.range(0, word.length() - 1)
                .mapToObj(index -> word.substring(index, index + 2))
                .filter(text -> text.chars().allMatch(character -> Character.isAlphabetic((char) character)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private Integer getIntersection(Map<String, Long> words1, Map<String, Long> words2) {
        return words1.entrySet().stream()
                .filter(entry -> words2.containsKey(entry.getKey()))
                .map(entry -> Math.min(entry.getValue(), words2.get(entry.getKey())))
                .mapToInt(Long::intValue)
                .sum();
    }

    private Integer getUnion(Map<String, Long> words1, Map<String, Long> words2) {
        Map<String, Long> copiedWords = new HashMap<>(words2);
        words1.forEach((key, value) -> copiedWords.put(key, Math.max(value, words2.getOrDefault(key, 0L))));

        return copiedWords.values().stream()
                .mapToInt(Long::intValue)
                .sum();

    }
}
