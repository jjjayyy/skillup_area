package algo_goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main_Sample {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputArr = input.split(" ");

        String a = inputArr[0];
        String b = inputArr[1];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        LocalDate date_a = LocalDate.parse(a, formatter);
        LocalDate date_b = LocalDate.parse(b, formatter);



        long day = ChronoUnit.DAYS.between(date_a, date_b);

        System.out.println(day);
    }

}
