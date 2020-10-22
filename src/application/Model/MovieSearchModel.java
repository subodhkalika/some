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

	public ArrayList<String> searchIn(HashMap<String, ArrayList<String>> movieTitles, String keyword) {
		ArrayList<String> matchedTitles = new ArrayList<String>();
		for (String i : movieTitles.keySet()) {
			System.out.println("key: " + i + " value: " + movieTitles.get(i));
			for (String title : movieTitles.get(i)) {
				if(title.toLowerCase().contains(keyword)) {
					matchedTitles.add(title);
				}
			}
		}
		return matchedTitles;
	}

	public ArrayList<String> parseXMLFile(File selectedFile, String keyword) {
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
		
		return this.titles;
	}
}