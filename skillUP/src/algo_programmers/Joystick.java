package algo_programmers;

public class Joystick {
    public static void main(String[] args) {
        System.out.println(solution("AAAZAAZA"));
    }

    //연속으로 A가 많이 들어가있는 부분에서 마지막 A의 index를 가져옴
    //A가 가장 많이 들어있는 부분을 A블럭이라고 하면 A블럭 앞의 index 구함
    //전체 길이에서 A블럭 제외하고 A블럭 기준 앞블럭 or 뒷블럭 중 작은 블럭에서 한번 더 더함 (찍고 돌아오는 경우)
    static int solution(String name) {
        int cnt = 0;
        int wordCnt = 0;
        int wordCntAll = 'Z'-'A'+1;
        int cntA = 0;
        int tempA = 1;
        boolean isPrevA = false;
        boolean isAllA = true;
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
            isAllA = false;
            isPrevA = false;
            wordCnt = name.charAt(i)-'A';
            cnt += Math.min(wordCnt, wordCntAll-wordCnt);
        }

        int minCount = name.length()-1;
        int startIdx = idxA - cntA;  // 연속된 A가 가장 많은거 이전 블럭
        int endIdx = minCount - idxA; // 연속된 A가 가장 많은거 이후 블럭

        if(cntA != 0) {
            if(startIdx > endIdx) {
                minCount = Math.min(minCount, (minCount - cntA + endIdx));
            } else {
                minCount = Math.min(minCount, (minCount - cntA + startIdx));
            }
        }
        return isAllA ? 0 : cnt + minCount;
    }
}
