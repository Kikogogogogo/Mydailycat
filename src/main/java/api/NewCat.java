package api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NewCat implements Mycatfacts {

    private static final String CAT_FACT_API_URL = "https://catfact.ninja/fact";

    @Override
    public String getRandomFact() {
        try {
            URL url = new URL(CAT_FACT_API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                String fact = response.toString();
                int startIndex = fact.indexOf("\"fact\":\"") + 8;
                int endIndex = fact.indexOf("\"", startIndex);
                return fact.substring(startIndex, endIndex);
            } else {
                return "Failed to get cat fact!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "An error occurred!";
        }
    }

    public static void main(String[] args) {
        NewCat cat = new NewCat();
        System.out.println(cat.getRandomFact());
    }
}
