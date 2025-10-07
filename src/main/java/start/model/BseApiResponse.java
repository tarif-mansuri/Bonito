//$Id$
package start.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BseApiResponse {
	
	@JsonProperty("Table")
	private List<NewsItem> table;
	
	public List<NewsItem> getTable(){
		return table;
	}

	public void setTable(List<NewsItem> table) {
		this.table = table;
	}
}

