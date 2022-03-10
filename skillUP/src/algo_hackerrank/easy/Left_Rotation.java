package algo_hackerrank.easy;

import java.util.ArrayList;
import java.util.List;

public class Left_Rotation {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        rotLeft(a,4);
    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        int size = a.size();
        int rotation = d % size;

        if(rotation > 0) {
            List<Integer> tempList = a.subList(0, rotation);
            a = a.subList(rotation, size);
            a.addAll(tempList);
        }

        return a;
    }
}
