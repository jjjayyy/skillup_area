//package skillUP_httpURLConnection;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpUriRequest;
//import org.apache.http.client.methods.RequestBuilder;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.text.SimpleDateFormat;
//import java.util.Base64;
//import java.util.Date;
//
//public class main {
//
//    public static void main(String[] args) throws Exception {
////        sendPostJson();
////        sendGetJson();
//        getData();
//    }
//
//    public static void sendPostJson() throws Exception {
//        //JSON 데이터 받을 URL 객체 생성
//        URL url = new URL ("https://webhook.site/0b19b1e6-beb4-42ad-987f-fa710e0b67aa");
//        //HttpURLConnection 객체를 생성해 openConnection 메소드로 url 연결
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        //전송 방식 (POST)
//        con.setRequestMethod("POST");
//        //application/json 형식으로 전송, Request body를 JSON으로 던져줌.
//        con.setRequestProperty("Content-Type", "application/json; utf-8");
//        //Response data를 JSON으로 받도록 설정
//        con.setRequestProperty("Accept", "application/json");
//        //Output Stream을 POST 데이터로 전송
//        con.setDoOutput(true);
//        //json data
//        String jsonInputString = "{id : faker, game : lol }";
//
//        //JSON 보내는 Output stream
//        try(OutputStream os = con.getOutputStream()) {
//            byte[] input = jsonInputString.getBytes("utf-8");
//            os.write(input, 0, input.length);
//        }
//
//        //Responsw data 받는 부분
//        try(BufferedReader br = new BufferedReader(
//                new InputStreamReader(con.getInputStream(), "utf-8"))) {
//            StringBuilder response = new StringBuilder();
//            String responseLine = null;
//            while ((responseLine = br.readLine()) != null) {
//                response.append(responseLine.trim());
//            }
//            System.out.println(response.toString());
//        }
//    }
//
//    public static void sendGetJson() throws Exception {
//        URL url = new URL ("https://webhook.site/0b19b1e6-beb4-42ad-987f-fa710e0b67aa");
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("GET");
//        con.setRequestProperty("Content-Type", "application/json; utf-8");
//        con.setRequestProperty("Accept", "application/json");
//
////        con.setRequestProperty("id", "faker");
////        con.setRequestProperty("game", "lol");
//
//        try(BufferedReader br = new BufferedReader(
//                new InputStreamReader(con.getInputStream(), "utf-8"))) {
//            StringBuilder response = new StringBuilder();
//            String responseLine = null;
//            while ((responseLine = br.readLine()) != null) {
//                response.append(responseLine.trim());
//            }
//            System.out.println(response.toString());
//        }
//    }
//
//    public static String getData() throws Exception {
//
//        Date today = new Date();
//        SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
//
//        String url = "";
//
//        final String USER = "a";
//        final String PW = "b";
//
//        String authText = USER + ":" + PW;
//
////        String encoded = DatatypeConverter.printBase64Binary(authText.getBytes());
//        String encodedAuth = Base64.getEncoder().encodeToString(authText.getBytes());
//        System.out.println(encodedAuth);
//
////        CloseableHttpClient client = HttpClients.custom().build();
////        CloseableHttpClient httpClient = HttpClients.createDefault();
////        HttpGet httpGet = new HttpGet(url);
//
//        HttpClient client = HttpClients.custom().build();
//        HttpUriRequest request = RequestBuilder.get()
//                .setUri(url)
//                .setHeader("Authorization","Basic " + encodedAuth)
//                .build();
////        HttpResponse response = client.execute(request);
//        HttpEntity entity = client.execute(request).getEntity();
//        System.out.println(entity.getContentType());
//        String responseString = EntityUtils.toString(entity, "UTF-8");
//
//        if(responseString.contains("error")) {
//            return "fail";
//        }
//
//        String[] resString = responseString.split("\\n");
//        String js = "";
//        for(int i = 0; i < resString.length; i++) {
//            if(resString[i].contains("097950")) {
//                js = resString[i];
//                break;
//            }
//        }
//
//        String jsi = js.replaceAll("\\s+",",");
//        String[] stockInfo = jsi.split(",");
//
//        System.out.println("=======================================");
//        System.out.println(jsi);
//        System.out.println(stockInfo[0].substring(0,8));
//        System.out.println(stockInfo[0].substring(20,26));
//        System.out.println(Long.parseLong(stockInfo[6]));
//        System.out.println(Long.parseLong(stockInfo[9]));
//
//        return "pass";
//    }
//
//}