package Etc_Test;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Localdate_test {

    @Test
    public void 현재날짜_yymmdd포멧() {
        LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        assertThat("20200727", is(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))));
    }

    @Test
    public void 날짜_차이() {
        LocalDate today = LocalDate.now();          //2020-07-27
        LocalDate targetDay = LocalDate.of(2018, 07, 29);

        Period period = targetDay.until(today);

        assertThat(1, is(period.getYears()));
        assertThat(11, is(period.getMonths()));

        long month = ChronoUnit.MONTHS.between(targetDay, today);
        System.out.println(month);

        assertThat(21, is(month));
    }

    @Test
    public void 스트링_파싱() {
        String string = "20190807";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(string, formatter);
        LocalDate today = LocalDate.now();

        long month = ChronoUnit.MONTHS.between(date, today);
        System.out.println(month);

    }
}
