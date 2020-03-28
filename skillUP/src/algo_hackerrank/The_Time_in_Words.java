package algo_hackerrank;

public class The_Time_in_Words {

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {

        String[] numWords = {
                "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eightteen", "nineteen", "twenty"

        };

        StringBuilder sb = new StringBuilder();

        sb.append(numWords[h]);

        boolean isOverHalf = false;

        if(m > 30) {
            m = 60 - m;
            isOverHalf = true;
        }


        if(isOverHalf) {
            sb.setLength(0);
            sb.append("to");
            sb.append(" " + numWords[h+1]);     //to five
        } else if(m != 0) {
            sb.insert(0, "past ");      //past five
        }

        switch (m) {
            case 15:
                sb.insert(0, "quarter ");
                break;
            case 30:
                sb.insert(0, "half ");
                break;
            default:
                if(m > 20) {
                    sb.insert(0, "minutes ");
                    sb.insert(0,numWords[m-20] + " ");
                    sb.insert(0, numWords[20] + " ");

                } else if (m != 0){
                    if(m == 1) {
                        sb.insert(0, "minute ");
                    } else {
                        sb.insert(0, "minutes ");
                    }
                    sb.insert(0, numWords[m] + " ");
                }
                 break;
        }

        if(m == 0) {
            sb.append(" o'clock");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(15/15);
        System.out.println(15%15);
        System.out.println(0%15);
        System.out.println(0/15);

        StringBuilder sd = new StringBuilder();
        System.out.println(sd.insert(0, "aa"));

        System.out.println(timeInWords(3,00));
    }

}
