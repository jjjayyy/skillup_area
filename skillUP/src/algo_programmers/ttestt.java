package algo_programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ttestt {
    public static void main(String[] args) {

        HashMap<String, Object> map = new HashMap<>();
        String[] strArr = {"A", "B", "C"};
        map.put("test", strArr);

        //List<String> list = Arrays.asList(map.get("test")).stream().map(v -> v.toString()).collect(Collectors.toCollection(ArrayList::new));

        List<Object> list = new ArrayList<>(Arrays.asList(map.get("test")));
        List<String> strList = list.stream().map(o -> o.toString()).collect(Collectors.toList());


        for(String item : strList) {
            System.out.println(item);
        }
    }
}
