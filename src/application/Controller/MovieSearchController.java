package application.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import application.Model.GraphModel;
import application.Model.MovieSearchModel;
import application.View.GraphView;
import application.View.MovieSearchView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MovieSearchController {
	private MovieSearchView view;
	private MovieSearchModel model;
	private String keyword;
	ArrayList<String> matchedKeywords = new ArrayList<String>();

	File selectedFile = null;

	public MovieSearchController(MovieSearchView view, MovieSearchModel model, File selectedFile, Stage stage) {
		this.view = view;
		this.model = model;
		
		this.view.btnSearchMovieListener(e -> {
			keyword = this.view.getSearchKeyword();
			this.view.clearMovieResults();
			System.out.println(this.view.getTextAreaSearchResult().getText());

			HashMap<String, ArrayList<String>> searchResults = this.model.searchIn(selectedFile, keyword);
			ArrayList<String> matchedMovieTitles = searchResults.get("titles");
			matchedKeywords = searchResults.get("keywords");

			for (String movieTitle : matchedMovieTitles) {
				this.view.addToMovieResults(movieTitle);
			}
			this.view.setBtnGotoGraphDisable(false);
		});
		
		this.view.btnGotoGraphListener(e -> { 
			GraphView graphView = new GraphView();
			GraphModel graphModel = new GraphModel();
			GraphController graphController = new GraphController(graphView, graphModel, selectedFile, stage, matchedKeywords);

			Scene scene = new Scene(graphView.asParent(), 500, 500);

			stage.setScene(scene);
			stage.setTitle("XML Keyword Search System");
			stage.show();
		});	
	}
}
