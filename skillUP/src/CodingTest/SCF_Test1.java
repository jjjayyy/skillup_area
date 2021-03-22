package CodingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SCF_Test1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int people = Integer.parseInt(br.readLine());

        String[][] timeArr = new String[people][2];
        String[] tempInput;
        int maxStartTime = 0;
        int minEndTime = 2400;
        int maxIndex = 0;
        int minIndex = 0;
        boolean isNoOne = false;

        for(int i = 0; i < timeArr.length; i++) {
            tempInput = br.readLine().replaceAll("\\s", "").split("~");

            timeArr[i][0] = tempInput[0];   // 시작시간
            timeArr[i][1] = tempInput[1];   // 종료시간

            int tempStartTime = Integer.parseInt(tempInput[0].replace(":", ""));
            int tempEndTime = Integer.parseInt(tempInput[1].replace(":", ""));

            if(maxStartTime < tempStartTime) {
                maxIndex = i;
                maxStartTime = tempStartTime;
            }

            if(minEndTime > tempEndTime) {
                minIndex = i;
                minEndTime = tempEndTime;
            }
        }

        for(String[] time : timeArr) {
            if(maxStartTime > Integer.parseInt(time[1].replaceAll(":", ""))) {
                isNoOne = true;
                break;
            }
        }

        System.out.println(isNoOne ? "-1" : timeArr[maxIndex][0]+ " ~ " + timeArr[minIndex][1]);


        // 시작시간의 최대
        // 종료시간의 최소
        // 종료시간 < 최대인 시작시간
        //System.out.println("Hello Goorm! Your input is " + input);
    }
}
