package algo_programmers;

public class Carpet {

    public static int[] solution(int brown, int yellow) {

        //         int sum = brown + yellow;
//         int heigth = 0;

//         for(int i = 1; i < sum; i++) {
//             if(sum % i == 0) {
//                 if(sum / i < i) {
//                     break;
//                 }
//                 heigth = i;
//             }
//         }

        int width = 0;
        int height = 0;



        for(int i = 1; i <= yellow; i++) {
            if(yellow == 1) {
                height = i + 2;
                width = (brown + yellow) / height;
                break;
            }

            if(yellow % i == 0) {
                if(brown == i * 2 + (yellow / i + 2) * 2) {
                    height = i + 2;
                    width = yellow / height;
                    break;
                }
            }
        }

        //int[] result = {sum / heigth, heigth};
        int[] result = {width , height};

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 1)[0]);
    }


}
