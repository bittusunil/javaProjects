package xml2json;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParserExample {

	List myCustomers;
	Document dom;


	public DomParserExample(){
		
		myCustomers = new ArrayList();
	}

	public void runExample() {
		
		
		parseXmlFile();
		
		
		parseDocument();
		
		printData();
		
	}
	
	
	private void parseXmlFile(){
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			
			
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			
			dom = db.parse("customer.xml");
			

		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

	
	private void parseDocument(){
		
		Element docEle = dom.getDocumentElement();
		
		
		NodeList nl = docEle.getElementsByTagName("Customer");
		if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {
				
				
				Element el = (Element)nl.item(i);
				Customers e = getCustomers(el);
				myCustomers.add(e);
			}
		}
	}


	
	private Customers getCustomers(Element empEl) {
		
		
		String name = getTextValue(empEl,"Name");
		int id = getIntValue(empEl,"Id");
		int age = getIntValue(empEl,"Age");

		String type = empEl.getAttribute("type");
		
		
		Customers e = new Customers(name,id,age);
		
		return e;
	}


	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}

	
	private int getIntValue(Element ele, String tagName) {
		
		return Integer.parseInt(getTextValue(ele,tagName));
	}
	
	
	private void printData(){
		
		System.out.println("No of Customers '" + myCustomers.size() + "'.");
		
		Iterator it = myCustomers.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

	
	public static void main(String[] args){
		
		DomParserExample dpe = new DomParserExample();
		
		
		dpe.runExample();
	}

}
