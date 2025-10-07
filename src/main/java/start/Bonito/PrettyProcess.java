//$Id$
package start.Bonito;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import start.dao.Data;
import start.model.BseApiResponse;
import start.model.NewsItem;

public class PrettyProcess {
	
	public void startProcess() {
		
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            // Call your BSE API logic here
        	
        	try {
                // Get today's date in the format YYYYMMDD
                LocalDate today = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                String formattedDate = today.format(formatter);

                // Construct the API URL
                String apiUrl = "https://api.bseindia.com/BseIndiaAPI/api/AnnSubCategoryGetData/w?" +
                        "pageno=1" +
                        "&strCat=Board+Meeting" +
                        "&strPrevDate=" + formattedDate +
                        "&strScrip=" +
                        "&strSearch=P" +
                        "&strToDate=" + formattedDate +
                        "&strType=C" +
                        "&subcategory=Board+Meeting";

                // Send GET request to the API
                @SuppressWarnings("deprecation")
				HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
                connection.setRequestMethod("GET");
                
                connection.setRequestProperty("User-Agent", 
                	    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " + 
                	    "(KHTML, like Gecko) Chrome/140.0.0.0 Safari/537.36");
                	connection.setRequestProperty("Accept", "application/json");
                	connection.setRequestProperty("Referer", "https://www.bseindia.com/");

                // Read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                
                ObjectMapper mapper = new ObjectMapper();
                String str = response.toString();
                JsonNode jsonNode = mapper.readTree(str);
                //BseApiResponse apiResponse = mapper.readValue(response.toString(), BseApiResponse.class);
                
                if (jsonNode.has("Table")) {
                	
                    for (JsonNode announcement : jsonNode.get("Table")) {
                    	NewsItem item = mapper.readValue(announcement.toString(), NewsItem.class);
                    	if(item.getMore().contains("bonus share")) {
                    		Data.addItem(item);
                    	}
                        
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        	
        };

        // Run every 1 minute
        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.MINUTES);
    }

}
