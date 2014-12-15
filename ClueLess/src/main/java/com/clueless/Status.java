package com.clueless;

import java.util.ArrayList;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;  
import javax.xml.bind.annotation.XmlElement;  

@XmlRootElement(name = "status")  
public class Status {  
	private boolean isMyTurn;
	private boolean isGamePlayable;
	private boolean isGameActive;
	private boolean allowSuggest;
	private boolean allowMove;
	
	private ArrayList<String> statusUpdate;
	private ArrayList<String> moveHistoryUpdate;
	
	private Map<String, String> locations;
  
	protected Status() {  
	}
	
	public Status(boolean isMyTurn, boolean isGamePlayable, boolean isGameActive, boolean allowSuggest, boolean allowMove, ArrayList<String> statusUpdate, ArrayList<String> moveHistoryUpdate, Map<String, String> locations) {
		this.isMyTurn = isMyTurn;
		this.isGamePlayable = isGamePlayable;
		this.isGameActive = isGameActive;
		this.allowSuggest = allowSuggest;
		this.allowMove = allowMove;
		
		this.statusUpdate = statusUpdate;
		this.moveHistoryUpdate = moveHistoryUpdate;
		
		this.locations = locations;
	}
	
	public boolean getIsMyTurn() {  
		return isMyTurn;  
	}  
		 
	@XmlElement
	public void setIsMyTurn(boolean isMyTurn) {  
		this.isMyTurn = isMyTurn;  
	}
	
	public boolean getIsGamePlayable() {  
		return isGamePlayable;  
	}  
		 
	@XmlElement
	public void setIsGamePlayable(boolean isGamePlayable) {  
		this.isGamePlayable = isGamePlayable;  
	}
	
	public boolean getIsGameActive() {  
		return isGameActive;  
	}
	
	@XmlElement
	public void setIsGameActive(boolean isGameActive) {  
		this.isGameActive = isGameActive;  
	}
	
	public boolean getAllowSuggest() {  
		return allowSuggest;  
	}
	
	@XmlElement
	public void setAllowSuggest(boolean allowSuggest) {  
		this.allowSuggest = allowSuggest;  
	}
	
	public boolean getAllowMove() {  
		return allowMove;  
	}  
		 
	@XmlElement
	public void setAllowMove(boolean allowMove) {  
		this.allowMove = allowMove;  
	}
	
	public ArrayList<String> getStatusUpdate() {  
		return statusUpdate;  
	}  
		 
	@XmlElement
	public void setStatusUpdate(ArrayList<String> statusUpdate) {  
		this.statusUpdate = statusUpdate;  
	}
	
	public ArrayList<String> getMoveHistoryUpdate() {  
		return moveHistoryUpdate;  
	}  
		 
	@XmlElement
	public void setMoveHistoryUpdate(ArrayList<String> moveHistoryUpdate) {  
		this.moveHistoryUpdate = moveHistoryUpdate;  
	}
	
	public Map<String,String> getLocations() {  
		return locations;  
	}  
		 
	@XmlElement
	public void setLocations(Map<String,String> locations) {  
		this.locations = locations;  
	}
}