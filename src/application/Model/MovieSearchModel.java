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

/**
 * Model for Movie Search page
 *
 * @author 	Subodh Kalika (102875446)
 * @author 	Sandesh Dhoju (102840091)
 * @version 2020.10.20
 */
public class MovieSearchModel {
	
	private HashMap<String, ArrayList<String>> movieResults = new HashMap<String, ArrayList<String>>();

	/**
	 * search in provided movie file's title for keywords
	 *
	 * @param File 									selected file from choose source page
	 * @param string 								keyword provided in movie search page by user
	 * @return HashMap<String, ArrayList<String>> 	movieResults with movie title and keywords
	 */
	public HashMap<String, ArrayList<String>> searchIn(File selectedFile, String keyword) {

		// Using DOM Parser
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = factory.newDocumentBuilder();	
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		}
		
		ArrayList<String> titles = new ArrayList<String>();
		ArrayList<String> keywords = new ArrayList<String>();
		
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
						titles.add(movieTitle);	//add movie titles to array list
						//Extract all keywords for matched title
						NodeList keywordLists = eElement.getElementsByTagName("kw");
	            	   	for (int count = 0; count < keywordLists.getLength(); count++) {		            		   
							Node nodeItem = keywordLists.item(count); 
							if (nodeItem.getNodeType() == nodeItem.ELEMENT_NODE) {
								Element item = (Element) nodeItem;
								String movieKw= item.getTextContent();
								keywords.add(movieKw);		
							}   
	            	   	}
					}
	            }
	        }
		} catch (SAXException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// Store in hash map
		this.saveInHashMap("keywords", keywords);
		this.saveInHashMap("titles", titles);
		return movieResults;
	}
	
	/**
	 * store each keyword (as the key) with its associated snippet
	 * 
	 * @param keyword	keyword to pass as a key in hash map
	 * @param snippet	value of the key
	 */
	public void saveInHashMap(String keyword,ArrayList<String> list) {
		ArrayList<String> keyValue = movieResults.get(keyword);
		if(keyValue != null) {
			movieResults.replace(keyword, list);
		}
		else {
			movieResults.put(keyword, list);
		}
	}
}