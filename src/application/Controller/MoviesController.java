package application.Controller;

import java.util.ArrayList;
import java.util.HashMap;

public class MoviesController {
	
	/**
	 * Method to save detail of movie
	 * 
	 * @param key	movie detail key
	 * @param newValue newValue for the key
	 */
	public void saveInHashMap(String key, ArrayList<String> newValue, HashMap<String, ArrayList<String>> movieTitles) {
		ArrayList<String> keyValue = movieTitles.get(key);
		if(keyValue != null) {
			movieTitles.replace(key, keyValue);
		}
		else {
			movieTitles.put(key, keyValue);
		}
	}
}
