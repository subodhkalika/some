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
 * Model for choose source page
 *
 * @author 	Subodh Kalika (102875446)
 * @author 	Sandesh Dhoju (102840091)
 * @version 2020.10.20
 */
public class ChooseSourceModel {
	private String content = "";
	private ArrayList<String> titles = new ArrayList<String>();

	/**
	 * parse XML file and get contents
	 *
	 * @param File			selected file from choose source page
	 * @return string		extracted content
	 */
	public String parseXMLFile(File selectedFile) {
		//Using DOM parser
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
			
			this.addToContent("Root element :" + doc.getDocumentElement().getNodeName(), true);
			
	        NodeList nList = doc.getElementsByTagName("movie");
	        this.addToContent("----------------------------------", true);
	        
	        for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
	            this.addToContent("\n");
	            this.addToContent("Current Element :" + nNode.getNodeName(), true);
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) nNode;
	               String movieTitle = eElement.getElementsByTagName("title").item(0).getTextContent();
	               this.titles.add(movieTitle);

	               String movieYear = eElement.getElementsByTagName("year").item(0).getTextContent();
	               String movieRating = eElement.getElementsByTagName("rating").item(0).getTextContent();
	               
	               this.addToContent("Title : " + movieTitle, true);
	               this.addToContent("Year : " + movieYear, true);
	               this.addToContent("Rating : " + movieRating, true);
	              
	               NodeList directorsList = eElement.getElementsByTagName("director");
	               String directors = "Director Name : ";
	               
	               
	               for (int count = 0; count < directorsList.getLength(); count++) {
	            	   Node nodeDirector = directorsList.item(count); 
	            	   if (nodeDirector.getNodeType() == nodeDirector.ELEMENT_NODE) {
	            		   Element director = (Element) nodeDirector;
	            		   String directorName = director.getElementsByTagName("name").item(0).getTextContent();
	            		   directors += directorName;
	            	   } 
	            	   if(count < directorsList.getLength() -1) {
	            		   directors += ", "; 
	            	   }
	               }
	               this.addToContent(directors, true);
	               
	               NodeList generesList = eElement.getElementsByTagName("item");
	               String generes = "Genre : ";
	               
	               for (int count = 0; count < generesList.getLength(); count++) {
	            	   Node nodeItem = generesList.item(count); 
	            	   if (nodeItem.getNodeType() == nodeItem.ELEMENT_NODE) {
	            		   Element item = (Element) nodeItem;
	            		   String genreName = item.getTextContent();
	            		   generes += genreName;
	                   }
	            	   if(count < generesList.getLength() -1) {
	            		   generes += ", "; 
	            	   }
	               }
	               this.addToContent(generes, true);
	            }
	         }
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return this.content;
	}

	/**
	 * Method to concat text to the content to return by model with new line
	 *
	 * @param string 	content to be concat
	 */
	public void addToContent(String content, Boolean withNewLine) {
		String additionalcontent = withNewLine ? "\n" + content : content;
		this.content = this.content + additionalcontent;
	}
	
	/**
	 * Method to concat text to the content to return by model without new line
	 *
	 * @param string	content to be concat
	 */
	public void addToContent(String content) {
		this.addToContent(content, false);
	}
}