package sillUP_stream;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Parallel_Stream {
    public static void main(String[] args) {
        List<String> employees = getEmployees();

        Instant start = Instant.now();      //실행 시작 시간
        employees.stream()
                .parallel()
                .forEach(Parallel_Stream::calcPay);
        Instant end = Instant.now();        //실행 종료 시간

        long elapsedTime = Duration.between(start, end).toMillis();
        System.out.println(elapsedTime);
    }

    private static List<String> getEmployees() {
        List<String> empList = new ArrayList<>();
        for(int i = 1; i <= 60; i++) {
            empList.add("emp" + i);
        }
        return empList;
    }

    private static void calcPay(String empNo) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        result(empNo);
    }

    private static void result(String empNo) {
        System.out.println("사번 : " + empNo + " // 쓰레드 이름 : " + Thread.currentThread().getName());
    }
}
