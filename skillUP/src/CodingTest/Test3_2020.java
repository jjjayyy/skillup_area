package CodingTest;

public class Test3_2020 {

    public static void main(String[] args) {

        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        System.out.println(info[0]);

        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        System.out.println(query[2].split(" and ")[1]);


    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = {};

        for(int i = 0; i < query.length; i++) {
            for(int j = 0; j < info.length; j++) {
                String[] queryItem = query[i].split(" and ");
                for(String item : queryItem) {

                }
            }

        }

        return answer;
    }
}
