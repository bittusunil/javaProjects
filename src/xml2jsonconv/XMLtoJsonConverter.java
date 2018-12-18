package xml2jsonconv;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.json.XML;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

import org.apache.commons.io.IOUtils;

public class XMLtoJsonConverter {
	 private URL url = null;
	    private InputStream inputStream = null;   
	    public void getXMLfromJson() {
	        try{
	            url = XMLtoJsonConverter.class.getClassLoader().getResource("customer.xml");
	            inputStream = url.openStream();
	            String xml = IOUtils.toString(inputStream);
	            JSON objJson = new XMLSerializer().read(xml);
	            System.out.println("JSON data : " + objJson);
	        }catch(Exception e){
	            e.printStackTrace();
	        }finally{
	     try {
	                if (inputStream != null) {
	                    inputStream.close();
	                }
	                
	            } catch (IOException ex) {}
	        }
	    }
	    public static void main(String[] args) {
	        new XMLtoJsonConverter().getXMLfromJson();
	    }
}
