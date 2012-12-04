package my.android.stuff;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;
import org.xml.sax.InputSource;


import android.util.Log;

public class XMLParser{
    
    private final String MY_DEBUG_TAG = "WeatherForcaster";
    private ParsedWeatherDataSet myDataSet;
    private Location myLocation;
    
    private static String beginURL = "http://www.google.com/ig/api?weather=";
    
    public XMLParser(ParsedWeatherDataSet p, Location l){
    	myDataSet = p;
    	myLocation = l;
    	DoParsing("Glasgow");
    	
    }

    
    
    public void DoParsing(String location){
            try {
                        // Create a URL we want to load some xml-data from. 
                        URL url = new URL(makeURL(location));
 
                       //Get a SAXParser from the SAXPArserFactory. 
                       SAXParserFactory spf = SAXParserFactory.newInstance();
                       SAXParser sp = spf.newSAXParser();
 
                        // Get the XMLReader of the SAXParser we created. 
                       XMLReader xr = sp.getXMLReader();
                        // Create a new ContentHandler and apply it to the XML-Reader
                       WeatherHandler myWeatherHandler = new WeatherHandler();
                       xr.setContentHandler(myWeatherHandler);
                       
                        // Parse the xml-data from our URL. 
                       xr.parse(new InputSource(url.openStream()));
                        // Parsing has finished
 
                        // Our ExampleHandler now provides the parsed data to us. 
                        myDataSet = myWeatherHandler.getParsedData();
 
                       
                       
                } catch (Exception e) {
                        /* Display any Error to the GUI. */
                       // tv.setText("Error: " + e.getMessage());
                       Log.e(MY_DEBUG_TAG, "WeatherQueryError", e);
                }

            

            
    }
    
    
    
    public String makeURL(String location)
    {
    	String urlString = beginURL + location + ",%20UK";
    	
    	return urlString;
    }
    
   
}