package xml2jsonconv;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class Xml2json {

    public static int num = 4;
    public static String TEST_XML_STRING =null;
          

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        try {
        	BufferedReader br = null;
        	   br = new BufferedReader(new FileReader("D:\\GeoLocation_WS\\xml2json\\customer.xml"));
      	      TEST_XML_STRING =br.readLine();
      	      while((TEST_XML_STRING=br.readLine()) !=null)
      	      {
      	    	JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
      	    	String jsonString=xmlJSONObj.toString(num);
                System.out.println(jsonString);
      	    
      	      }
      	        
            
        } catch (JSONException je) {
            System.out.println(je.toString());
        }
    }
}
