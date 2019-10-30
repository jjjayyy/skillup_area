package skillUP_httpURLConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class main {

    public static void main(String[] args) throws Exception {
        sendPostJson();
        sendGetJson();
    }

    public static void sendPostJson() throws Exception {
        //JSON 데이터 받을 URL 객체 생성
        URL url = new URL ("www.google.com");
        //HttpURLConnection 객체를 생성해 openConnection 메소드로 url 연결
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        //전송 방식 (POST)
        con.setRequestMethod("POST");
        //application/json 형식으로 전송, Request body를 JSON으로 던져줌.
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        //Response data를 JSON으로 받도록 설정
        con.setRequestProperty("Accept", "application/json");
        //Output Stream을 POST 데이터로 전송
        con.setDoOutput(true);
        //json data
        String jsonInputString = "{id : faker, game : lol }";

        //JSON 보내는 Output stream
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        //Responsw data 받는 부분
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }

    public static void sendGetJson() throws Exception {
        URL url = new URL ("www.google.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");

        con.setRequestProperty("id", "faker");
        con.setRequestProperty("game", "lol");

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }

}