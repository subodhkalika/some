package application.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import application.Model.MovieSearchModel;
import application.View.MovieSearchView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MovieSearchController {
	private MovieSearchView view;
	private MovieSearchModel model;
	private Stage stage;
	
	public MovieSearchController(MovieSearchView view, MovieSearchModel model, File selectedFile, Stage stage, HashMap<String, ArrayList<String>> movieTitles) {
		this.view = view;
		this.model = model;
		this.stage = stage;
		
		this.view.btnSearchMovieListener(e -> {
			String keyword = this.view.getSearchKeyword();
			System.out.print(keyword);
			ArrayList<String> matchedMovieTitles = this.model.parseXMLFile(selectedFile, keyword);
			for (String movieTitle : matchedMovieTitles) {
				System.out.print(movieTitle);
				this.view.addToMovieResults(movieTitle);
			}
		});	
		
		this.view.btnGotoGraphListener(e -> { 
			
		});	
	}
}
