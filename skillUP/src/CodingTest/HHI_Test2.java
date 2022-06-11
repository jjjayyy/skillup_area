package CodingTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class HHI_Test2 {
    public static void main(String[] args) {
//        String[] birth = {"1899-13-31", "19001231", "2001-09-04", "1900-02-29", "2021-5-31", "1950-11-30", "1996-02-29", "1999-11-31", "2000-02-29"};
        String[] birth = {"-2019-12-29-", "1945--10-31", "----------", "20000-123-567"};
        solution(birth);
    }

    public static int solution(String[] birth) {

        int answer = 0;
        for(String birthDate : birth) {
            answer += validateDate(birthDate);
        }
        System.out.println(answer);
        return answer;
    }

    private static int validateDate(String birth) {
        try {
            LocalDate date = LocalDate.parse(birth, DateTimeFormatter.ISO_DATE);
            if(date.getYear() < 1900 || date.getYear() > 2021) {
                return 0;
            }
            return 1;
        } catch (DateTimeParseException dte) {
            return 0;
        }
    }
}
