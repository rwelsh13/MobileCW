package my.android.stuff;

import android.text.Editable;

public class Location {
	
	private String currentLoc;
	private String partURL;
	private String finalURL;
	
	public Location(){
		
		//Glasgow as Default
		this.currentLoc = "Glasgow";
	}

	public void setLocation(String loc) {
		currentLoc = loc;
		
	}

	public String getLocation() {
		
		return currentLoc;
	}

}
