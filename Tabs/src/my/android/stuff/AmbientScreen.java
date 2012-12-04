package my.android.stuff;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AmbientScreen {
	
	ParsedWeatherDataSet parsedWeatherDataSet;
	private LinearLayout myLayout;
	
	public AmbientScreen(LinearLayout lay_ambient){
		
		//this.parsedWeatherDataSet = parsedWeatherDataSet;
		this.myLayout = lay_ambient;
	}
	
	 /*This method will take the temperature from the parsed data 
     * and change the background colour of the app depending on 
     * what range it fits into
    */
    public void setAmbientColour(int i)
    {
    	//obtain the value of the temperature from the parsed data
    	int temp = i;
    	
    	//blue for below zero
    	if(temp < 0  )
    	{
    		myLayout.setBackgroundColor(Color.BLUE);
    	}//green for 0 to 10
    	else if(temp > 0 && temp < 10)
    	{ 
    		myLayout.setBackgroundColor(Color.GREEN);
    	}//the else will catch anything 10+ and make the colour yellow
    	else
    	{
    		myLayout.setBackgroundColor(Color.YELLOW);
    	}
    	
    	
    }

}
