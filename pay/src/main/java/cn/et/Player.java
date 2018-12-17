package cn.et;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinition;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
	private String playerId;
	private String playerUrl;
	private String imageUrl;
	private String showTitle;
	

	
}
