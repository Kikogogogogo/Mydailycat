package api;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;

public class NewCat2 implements Mycatpicture {

    private static final String CAT_IMAGE_API_URL = "https://api.thecatapi.com/v1/images/search";
    private static final String CAT_API_KEY = "live_boApMgnSFSNdKn0fAza0M0BEel8UFSHToPv52YGwkxsShtgaASlaEUFZ1jDMMlSR";

    @Override
    public File getPicture() {
        try {
            URL url = new URL(CAT_IMAGE_API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("x-api-key", CAT_API_KEY);

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("HTTP response code: " + responseCode);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONArray jsonArray = new JSONArray(response.toString());
            String imageUrl = jsonArray.getJSONObject(0).getString("url");

            URL imgUrl = new URL(imageUrl);
            InputStream is = imgUrl.openStream();
            File outFile = new File("randomCatImage.jpg");
            FileOutputStream fos = new FileOutputStream(outFile);

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            is.close();
            fos.close();

            return outFile;
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
