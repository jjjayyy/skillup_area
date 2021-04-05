package algo_programmers;

public class Joystick {
    public static void main(String[] args) {
        System.out.println(solution("BBAABAAAAB"));
    }

    static int solution(String name) {
        int cnt = 0;
        int wordCnt = 0;
        int wordCntAll = 'Z'-'A'+1;
        int cntA = 0;
        int tempA = 1;
        boolean isPrevA = false;
        int idxA = 0;

        for(int i = 0; i < name.length(); i++) {
            if(name.charAt(i) == 'A') {
                if(isPrevA) tempA++;
                if(cntA < tempA) {
                    cntA = tempA;
                    idxA = i;
                }

                isPrevA = true;
                continue;
            }
            tempA = 1;
            isPrevA = false;
            wordCnt = name.charAt(i)-'A';
            cnt += Math.min(wordCnt, wordCntAll-wordCnt);
        }

        int minCount = name.length()-1; //기본 이동거리는 길이 - 1
        int startIdx = idxA - cntA;  // 연속된 A가 가장 많은거 이전 블럭
        int endIdx = minCount - idxA; // 연속된 A가 가장 많은거 이후 블럭

        if(cntA != 0) {
            if(startIdx > endIdx) {
                minCount = minCount - cntA + endIdx;
            }
            minCount -
        }

        for(int i = 0; i < name.length(); i++) {
            if(cntA != 0) {

            }
        }
        return cnt + minCount;
    }
}
