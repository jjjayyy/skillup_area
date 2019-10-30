package skillUP_httpURLConneciton;

public class main {

    public static void main(String[] args) {
        URL url = new URL ("https://reqres.in/api/users");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        sendPostJson(con);
    }

    public static void sendPostJson(HttpURLConnection con) {

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");

        con.setDoOutput(true);
        String jsonInputString = "{id : faker, game : lol }";

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

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

    public static void sendGetJson() {

    }
}