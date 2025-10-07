//$Id$
package start.dao;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import start.Bonito.TelegramNotifier;
import start.model.NewsItem;

public class Data {
	
	private static List<NewsItem> items = new ArrayList<>();
	
	public static void addItem(NewsItem item) {
		LocalTime now = LocalTime.now();

        // Define start and end time
        LocalTime start = LocalTime.of(8, 0);  // 08:00 AM
        LocalTime end = LocalTime.of(8, 2);    // 08:02 AM

        // Check if current time is between start and end (inclusive)
        if (!now.isBefore(start) && !now.isAfter(end)) {
        	System.out.println("clearing the cache");
        	clearCache();
        }
		//if item does not exists add
		for(NewsItem e : items) {
			if(e.getNewsId().toString().equals(item.getNewsId())) {
				return;
			}
		}
		
		//Add item and notify
		items.add(item);
		try {
			for(int i=0; i<5; i++) {
				TelegramNotifier.sendMessage(item.getNewsSub().substring(0, 20));
				TelegramNotifier.sendMessage(item.getMore());
				Thread.sleep(10000);
			}
			
		}catch(Exception e) {
			
		}
	}
	
	public static List<NewsItem> getItems(){
		return items;
	}
	
	public static void clearCache() {
		items = new ArrayList<>();
	}

}
