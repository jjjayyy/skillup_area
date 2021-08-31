package algo_programmers;

public class Weekly_2week {
    public static void main(String[] args) {

        int[][] scores = {{70, 70, 70, 70},{50, 50, 50, 50}, {70, 70, 70, 70}, {50, 50, 50, 50}};
        System.out.println(solution(scores));
    }

    public static String solution(int[][] scores) {
        StringBuilder grade = new StringBuilder();

        for(int i = 0; i < scores.length; i++) {
            int selfScore = scores[i][i];
            int average = 0;
            int max = scores[i][i];
            int min = scores[i][i];
            boolean same = false;
            int count = scores.length;

            for(int j = 0; j < scores[i].length; j++) {
                average += scores[j][i];

                if(i != j) {
                    max = Math.max(max, scores[j][i]);
                    min = Math.min(min, scores[j][i]);
                    if(!same) {
                        same = scores[j][i] == selfScore;
                    }
                }
            }

            if((max == selfScore || min == selfScore) && !same) {
                average -= selfScore;
                count--;
            }

            average = average / count;
            System.out.println(average);
            grade.append(getGrade(average));
        }
        return grade.toString();
    }

    private static String getGrade(int score) {
        if(score >= 90) {
            return "A";
        }

        if(score >= 80) {
            return "B";
        }

        if(score >= 70) {
            return "C";
        }

        if(score >= 50) {
            return "D";
        }

        return "F";
    }

}
