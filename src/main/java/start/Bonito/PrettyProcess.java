//$Id$
package start.Bonito;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import start.dao.Data;
import start.model.NewsItem;

public class PrettyProcess {
	
	Data data = new Data();
	
	public void startProcess() {
		
                System.out.println("Do the task now! Time ".concat(LocalDateTime.now(ZoneId.of("UTC")).toString()));
                System.out.println("Do the task now! Time ".concat(LocalDateTime.now().toString()));
                
                try {
                    // Get today's date in the format YYYYMMDD
                    LocalDate today = LocalDate.now();
                    LocalDate yesterday = today.minusDays(1);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                    String toDate = today.format(formatter);
                    String fromDate = yesterday.format(formatter);

                    // Construct the API URL
                    String apiUrl = "https://api.bseindia.com/BseIndiaAPI/api/AnnSubCategoryGetData/w?" +
                            "pageno=1" +
                            "&strCat=Board+Meeting" +
                            "&strPrevDate=" + fromDate +
                            "&strScrip=" +
                            "&strSearch=P" +
                            "&strToDate=" + toDate +
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
                    
                    //int count = 0;
                    
                    if (jsonNode.has("Table")) {
                    	
                        for (JsonNode announcement : jsonNode.get("Table")) {
                        	NewsItem item = mapper.readValue(announcement.toString(), NewsItem.class);
                        	//System.out.println(item.getMore());
                        	//count++;
                        	if(item.getMore().contains("bonus share") || item.getMore().contains("stock split")) {
                        		data.addItem(item);
                        	}
                            
                        }
                        //System.out.println(count);
                        
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

    }

}
