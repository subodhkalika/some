package application.Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import application.Handler.MovieHandler;

public class GraphModel {
	HashMap<String, Integer> freqyencyMap = new HashMap<String, Integer>(); 
			
	public HashMap<String, Integer> findKeywordFrequency(File selectedFile) {
		//obtain and configure a SAX based Parser 
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		//obtain object for SAX Parser
		SAXParser saxparser = null;
		try {
			saxparser = factory.newSAXParser();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
				saxparser.parse(selectedFile.getPath(), new MovieHandler());
				ArrayList<String> keywordList = MovieHandler.keywordsList;
				for(String singleKeyword : keywordList) {
					int keywordCount = 0;
					for(String kw : keywordList) {
						if (kw == singleKeyword) {
							keywordCount++;
						}       
					}
					//store frequency of keyword
					freqyencyMap.put(singleKeyword, keywordCount);
				}
			} catch (SAXException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		return this.freqyencyMap;
	}
	
	public void getKeywordsFromSearch() {
		
	}
}