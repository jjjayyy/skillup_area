package algo_hackerrank;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Compare_the_Triplets {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        int aScore = 0;
        int bScore = 0;

        for(int i = 0; i < a.size(); i++) {
            if(a.get(i) == b.get(i)){
                continue;
            }

            if(a.get(i) > b.get(i)) {
                aScore++;
            } else {
                bScore++;
            }
        }

        return Stream.of(aScore, bScore).collect(toList());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
