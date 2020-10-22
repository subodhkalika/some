package application.Model;
	
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MovieSearchModel {
	
	private ArrayList<String> titles = new ArrayList<String>();
	private ArrayList<String> keywords = new ArrayList<String>();
	private HashMap<String, ArrayList<String>> movieResults = new HashMap<String, ArrayList<String>>();

	public HashMap<String, ArrayList<String>> searchIn(File selectedFile, String keyword) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = factory.newDocumentBuilder();	
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		}
		try {
			Document doc = docBuilder.parse(selectedFile.getPath());
			doc.getDocumentElement().normalize();
			
	        NodeList nList = doc.getElementsByTagName("movie");
	        for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) nNode;
	               String movieTitle = eElement.getElementsByTagName("title").item(0).getTextContent();
	               if(movieTitle.toLowerCase().contains(keyword.toLowerCase())) {	
						this.titles.add(movieTitle);
						
						//Extract all keywords for matched title
						NodeList keywordList = eElement.getElementsByTagName("kws");
		            	for (int count = 0; count < keywordList .getLength(); count++) {
		            	    Node nodeKw = keywordList.item(count); 
		            	    if (nodeKw.getNodeType() == nodeKw.ELEMENT_NODE) {
		                         Element kw = (Element) nodeKw;
		                         this.keywords.add(kw.getElementsByTagName("kw").item(0).getTextContent());
		            	    }   
		            	}
					}
	            }
	        }
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		movieResults.put("titles", this.titles);
		movieResults.put("keywords", this.keywords);

		return movieResults;
	}
}