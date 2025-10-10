//$Id$
package start.dao;

import java.util.ArrayList;
import java.util.List;

import start.Bonito.TelegramNotifier;
import start.model.NewsItem;

public class Data {
	
	private List<NewsItem> items = new ArrayList<>();
	
	public void addItem(NewsItem item) {
		
		//if item does not exists add
		for(NewsItem e : items) {
			if(e.getNewsId().toString().equals(item.getNewsId())) {
				return;
			}
		}
		
		//Add item and notify
		items.add(item);
			
		TelegramNotifier.sendMessage(item.getNewsSub().substring(0, 20));
		TelegramNotifier.sendMessage(item.getMore());
			
			
		
	}

}
