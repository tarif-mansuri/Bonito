//$Id$
package start.Bonito;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TelegramNotifier {
    private static final String BOT_TOKEN = "8490060359:AAEniPUahAlN_SYyckNEqB9mkPeaRgUQlrU";
    private static final String CHAT_ID = "6512848567";

    public static void sendMessage(String message) {
        try {
            String urlString = "https://api.telegram.org/bot" + BOT_TOKEN + "/sendMessage";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonPayload = "{\"chat_id\":\"" + CHAT_ID + "\",\"text\":\"" + message + "\"}";

            try (OutputStream os = conn.getOutputStream()) {
                os.write(jsonPayload.getBytes());
            }
            
            
           

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                System.out.println(message);
            } else {
                System.out.println("Error sending message, response code: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
