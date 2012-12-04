package my.android.stuff;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class TabsActivity extends Activity implements View.OnClickListener {

    private ParsedWeatherDataSet myParsedData;
    private XMLParser myParser;
    private Location myLocation;
    
    private AmbientScreen myAmbientScreen; 
    private InfoScreen todayScreen;
    private InfoScreen tomoScreen;
    private LinearLayout lay_ambient;
    
    private TextView tvTest;
    private EditText edtLocation;
    
    
    
    /*TODO
     * parse everything
     * split it into days
     * 
     * SET TEMP DOESNT WORK, PARSE SHIT
     *
     * 1. learn buttons - DONE
     * 2. test it with change b.g color - DONE	
     * 3. learn to join strings together
     * 4. take in string and add it onto google url
     * REFRESH BUTTON
     * SETTINGS TAB - PUT CITY INTO STRING
     * (if there is a space, %20 )
     * gps latitute
     * reverse geocode it into city 
     * 
     * display images from link
     * 
     */

	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		
		//Creates our tabbed interface 
		createTabbedLayout();		
		lay_ambient = (LinearLayout)findViewById(R.id.tab1);
		tvTest = (TextView)findViewById(R.id.textView2);
		edtLocation = (EditText)findViewById(R.id.edtLocation);
		
		//our location - Glasgow as default until settings are changed
		myLocation = new Location();
		//data sheet that our parser will use
		myParsedData = new ParsedWeatherDataSet();
		//parser 
		myParser = new XMLParser(myParsedData, myLocation);
		
		myAmbientScreen = new AmbientScreen(lay_ambient);
		myAmbientScreen.setAmbientColour(myParsedData.getTemp());
		
		String s1 = "ry";
		String s2 = "an";
		String s3  = s1 + s2;
		
		tvTest.setText(Integer.toString(myParsedData.getTemp()));
		
		
	}
	
	public void onClick(View v){}
    
	//this is the set location button for now
    public void RefreshBtn(View v)
    {
    	myLocation.setLocation(edtLocation.toString());
    	myParser.DoParsing(myLocation.getLocation());
    	myAmbientScreen.setAmbientColour(myParsedData.getTemp());
    }
	
	//Sets up our content view with tabs 
	private void createTabbedLayout(){
		//DEAL WITH THE TABBED LAYOUT 
		setContentView(R.layout.tabs);
		TabHost th = (TabHost)findViewById(R.id.tabhost);
		th.setup();
		
		TabSpec specs= th.newTabSpec("tag1");
		specs.setContent(R.id.tab1);
		specs.setIndicator("Ambient");
			th.addTab(specs);
		specs= th.newTabSpec("tag2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("Today");
			th.addTab(specs);
		specs= th.newTabSpec("tag3");
		specs.setContent(R.id.tab3);
		specs.setIndicator("Tomorrow");
			th.addTab(specs);
		specs= th.newTabSpec("tag4");
		specs.setContent(R.id.tab4);
		specs.setIndicator("Settings");
			th.addTab(specs);
		/*
		 * Use the following code for a new tab
		 * specs= th.newTabSpec("tagX");
			specs.setContent(R.id.exampleID);
			specs.setIndicator("Example Title");
			th.addTab(specs);
		 */
	}
	

}