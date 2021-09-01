package algo_programmers;

import java.util.*;

public class Weekly_3week {

    public static void main(String[] args) {
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages = {"PYTHON", "C++", "SQL"};
        int[] preference = {7,5,5};

        System.out.println(solution(table, languages, preference));
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        for(String tableStr : table) {
            String[] temp = tableStr.split(" ");
            String job = temp[0];
            int sum = 0;

            for(int i = 1; i < temp.length; i++) {
                for(int j = 0; j < languages.length; j++) {
                    if(temp[i].equals(languages[j])) {
                        sum += (6-i) * preference[j];
                    } else {
                        sum += 0;
                    }
                }
            }
            map.put(job, sum);
        }

        int max = 0;
        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);

        for(String key : keyList) {
            if(max < map.get(key)) {
                max = map.get(key);
                builder.setLength(0);
                builder.append(key);
            }
        }

        return builder.toString();
    }
}
