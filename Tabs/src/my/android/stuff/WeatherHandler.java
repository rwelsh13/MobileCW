package my.android.stuff;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
 
 
public class WeatherHandler extends DefaultHandler{
 
        
       
        private boolean bWeather = false;
        private boolean bCurren_weather = false;
        private boolean bTemp = false;
       
        private ParsedWeatherDataSet myParsedWeatherDataSet = new ParsedWeatherDataSet();
 
        
 
        public ParsedWeatherDataSet getParsedData() {
                return this.myParsedWeatherDataSet;
        }
 
        
        @Override
        public void startDocument() throws SAXException {
                this.myParsedWeatherDataSet = new ParsedWeatherDataSet();
        }
 
        @Override
        public void endDocument() throws SAXException {
                // Nothing to do
        }
 
        /* Gets be called on opening tags like:
         * <tag>
         * Can provide attribute(s), when xml was like:
         * <tag attribute="attributeValue">*/
        @Override
        public void startElement(String namespaceURI, String localName,
                        String qName, Attributes atts) throws SAXException {
                if (localName.equals("weather")) 
                {
                        this.bWeather = true;
                }
                else if (localName.equals("curren_weather")) 
                {
                        this.bCurren_weather = true;
                }
                else if (localName.equals("temp")) 
                {
                        this.bTemp = true;
                }
        }
       
        /** Gets be called on closing tags like:
         * </tag> */
        @Override
        public void endElement(String namespaceURI, String localName, String qName)
                        throws SAXException {
                if (localName.equals("weather")) {
                        this.bWeather = false;
                }else if (localName.equals("curren_weather")) {
                        this.bCurren_weather = false;
                }else if (localName.equals("temp")) {
                        this.bTemp = false;
                }else if (localName.equals("temp_unit")) {
                        // Nothing to do here
                }
        }
       
        // Gets be called on the following structure:
        //<tag>characters</tag> 
        @Override
    public void characters(char ch[], int start, int length) {
        	if (bTemp) {
    			String sTemp =  new String(ch, start, length);
    			myParsedWeatherDataSet.setTemp(Integer.parseInt(sTemp));
    		}
        }
    }
