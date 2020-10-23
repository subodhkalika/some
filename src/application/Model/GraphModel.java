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

/**
 * Model for Movie Search page
 *
 * @author 	Subodh Kalika (102875446)
 * @author 	Sandesh Dhoju (102840091)
 * @version 2020.10.20
 */
public class GraphModel {
	HashMap<String, Integer> frequencyMap = new HashMap<String, Integer>(); 
	
	/**
	 * find the frequency of each keyword in the IMDB database
	 *
	 * @param File 							selected file from choose source page
	 * @return HashMap<String, Integer>		frequencyMap with title and frequency
	 */
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
					frequencyMap.put(singleKeyword, keywordCount);
				}
			} catch (SAXException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		return this.frequencyMap;
	}
	
	/**
	 * sort keywords descending order of frequency
	 *
	 * @param ArrayList<String> 			matchedKeywords from the search page
	 * @param HashMap<String, Integer> 		frequenciesMap with title and frequency
	 * @return ArrayList<String> 			sorted matchedKeywords in descending order of frequency
	 */
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
	
	/**
	 * Method to get top n keywords
	 *
	 * @param string 				selectedCritera, value of radio button
	 * @param ArrayList<String> 	keywords
	 * @return ArrayList<String> 	topNkeyWords
	 */
	public ArrayList<String> getTopNKeywords(String selectedCriteria, ArrayList<String> keywords) {
		int size = this.getValueOfNBySelectedCriteria(selectedCriteria);
		ArrayList<String> topNkeyWords = new ArrayList<String>();
		for(int i = 0; i < size; i++) {
			topNkeyWords.add(keywords.get(i));
		}
		return topNkeyWords;
	}
	
	/**
	 * Method to get top n keywords
	 *
	 * @param string 		selectedCritera, value of radio button
	 * @return integer 	
	 */
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