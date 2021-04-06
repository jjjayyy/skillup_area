package algo_programmers;

import java.util.Arrays;

public class Lifeboat {
    public static void main(String[] args) {
        int[] people = {160, 150, 140, 60, 50, 40};
        System.out.println(solution(people, 200));
    }

    static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int cnt = 0;
        int tempIdx = 0;

        for(int i = people.length-1; i >= 0; i--) {
            if(people[i] == 0) {
                break;
            }

            int rest = limit - people[i];

            if(rest >= 40) {
                for(int j = tempIdx; j < people.length; j++) {
                    if(rest < people[j] || people[j] == 0) {
                        break;
                    }
                    rest -= people[j];
                    tempIdx = j+1;
                    people[j] = 0;
                }
            }
            people[i] = 0;
            cnt++;
        }
        return cnt;
    }
}
