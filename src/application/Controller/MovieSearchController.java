package application.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import application.Model.GraphModel;
import application.Model.MovieSearchModel;
import application.Store.MoviesStore;
import application.View.GraphView;
import application.View.MovieSearchView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MovieSearchController {
	private MovieSearchView view;
	private MovieSearchModel model;
	private String keyword;

	File selectedFile = null;

	public MovieSearchController(MovieSearchView view, MovieSearchModel model, File selectedFile, Stage stage) {
		this.view = view;
		this.model = model;
		MoviesStore mvs = new MoviesStore();
		this.view.btnSearchMovieListener(e -> {
			keyword = this.view.getSearchKeyword();
			this.view.clearMovieResults();
			
			HashMap<String, ArrayList<String>> searchResults = this.model.searchIn(selectedFile, keyword);
			ArrayList<String> matchedMovieTitles = searchResults.get("titles");
			mvs.matchedKeywords = searchResults.get("keywords");

			for (String movieTitle : matchedMovieTitles) {
				this.view.addToMovieResults(movieTitle);
			}
			this.view.setBtnGotoGraphDisable(false);
		});
		
		this.view.btnGotoGraphListener(e -> { 
			GraphView graphView = new GraphView();
			GraphModel graphModel = new GraphModel();
			
			GraphController graphController = new GraphController(graphView, graphModel, selectedFile, stage, mvs.matchedKeywords);

			Scene scene = new Scene(graphView.asParent(), 300, 300);

			stage.setScene(scene);
			stage.setTitle("XML Keyword Search System");
			stage.show();
		});	
	}
}
