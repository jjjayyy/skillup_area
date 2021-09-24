package algo_goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Game_369 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int inputNum = Integer.parseInt(input);
        int clapCnt = 0;

        for(int i = 1; i < inputNum; i++) {
            int num = i;
            while(num > 0) {
                int lastNum = num % 10;
                if(lastNum != 0 && lastNum % 3 == 0) {
                    clapCnt++;
                }
                num /= 10;
            }
        }

        System.out.println(clapCnt);
    }
}
