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
	
	public ArrayList<String> getSortedKeywords(ArrayList<String> matchedKeywords,HashMap<String, Integer> frequenciesMap) 
    { 
        int size = matchedKeywords.size(); 
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size-i-1; j++) {
            	String d = matchedKeywords.get(j);
            	int x = frequenciesMap.get(d);
            	int y = frequenciesMap.get(matchedKeywords.get(j+1));
                if (x > y) {
                    String temp = matchedKeywords.get(j); 
                    matchedKeywords.set(j, matchedKeywords.get(j+1)); 
                    matchedKeywords.set(j+1, temp);
                }
            }
        }

        return matchedKeywords;
    }
	
	public ArrayList<String> getTopNKeywords(String selectedCriteria, ArrayList<String> keywords) {
		int size = this.getValueOfNBySelectedCriteria(selectedCriteria);
		ArrayList<String> topNkeyWords = new ArrayList<String>();
		for(int i = 0; i < size; i++) {
			topNkeyWords.add(keywords.get(i));
		}
		return topNkeyWords;
	}
	
	public int getValueOfNBySelectedCriteria(String selectedCriteria) {
		if (selectedCriteria == "TOP_3") {
			return 3;
		} else if (selectedCriteria == "TOP_5") {
			return 5;
		} else if (selectedCriteria == "TOP_8") {
			return 8;
		} else {
			return 10;
		}
	}
}