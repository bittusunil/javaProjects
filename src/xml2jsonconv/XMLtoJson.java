package xml2jsonconv;

import org.json.XML;
import net.sf.json.JSONObject;
import org.json.JSONException;

public class XMLtoJson {
	public static void main(String[] args) throws JSONException {
	    String xml = "<employee><name>ABC</name><age>32</age></employee>";
	    org.json.JSONObject obj = XML.toJSONObject(xml);
	    System.out.println(obj);
	  }

}
