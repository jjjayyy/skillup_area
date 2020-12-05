package Etc_Test;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        LocalDate targetDay = LocalDate.of(1995, 02, 01);
        LocalDate aboutToday = LocalDate.of(2020, 07, 01);

        Period period = targetDay.until(today);

        long month = ChronoUnit.MONTHS.between(targetDay, aboutToday);
        System.out.println(month);

        assertThat(21, is(month));
    }

    @Test
    public void 스트링_파싱() {
        String string = "20190807";
        String string2 = "20201007";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(string, formatter);
        LocalDate date2 = LocalDate.parse(string2, formatter);
        LocalDate today = LocalDate.now();

        long month = ChronoUnit.MONTHS.between(date, date2);
        System.out.println(month);

    }

    @Test
    public void 리스트_객체_제거() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

        map.put("First", "1");
        map.put("Second", "2");
        map.put("Third","3");
        list.add(map);

        map = new HashMap<>();

        map.put("First", "4");
        map.put("Second", "5");
        map.put("Third","6");
        list.add(map);

        list.removeIf(i->i.get("Second").equals("2"));

//        for(Map<String,Object> item : list) {
//            if(item.get("Second").equals("5")) {
//                list.remove(item);
//            }
//        }

        System.out.println(list);

    }

}
