package application.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import application.Model.ChooseSourceModel;
import application.Model.GraphModel;
import application.Model.MovieSearchModel;
import application.Store.MoviesStore;
import application.View.ChooseSourceView;
import application.View.GraphView;
import application.View.MovieSearchView;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controller for movie search page
 *
 * @author 	Subodh Kalika (102875446)
 * @author 	Sandesh Dhoju (102840091)
 * @version 2020.10.20
 */
public class MovieSearchController {
	private MovieSearchView view;
	private MovieSearchModel model;
	private String keyword;

	File selectedFile = null;

	/**
	 * Constructor for MovieSearchController
	 *
	 * @param MovieSearchView 		view
	 * @param MovieSearchModel 		model
	 * @param File 					selectedFile
	 * @param Stage 				stage
	 */
	public MovieSearchController(MovieSearchView view, MovieSearchModel model, File selectedFile, Stage stage) {
		this.view = view;
		this.model = model;

		MoviesStore mvs = new MoviesStore();		// instantiation of movie store
		
		// search in IMDB database
		// listener for search button
		this.view.btnSearchMovieListener(e -> {
			keyword = this.view.getSearchKeyword();
			
			HashMap<String, ArrayList<String>> searchResults = this.model.searchIn(selectedFile, keyword);
			ArrayList<String> matchedMovieTitles = searchResults.get("titles");
			mvs.matchedKeywords = searchResults.get("keywords");
			
			String searchResultsString = "";
			for (String movieTitle : matchedMovieTitles) {
				searchResultsString+= movieTitle  + "\n";
			}
			
			this.view.addToMovieResults(searchResultsString);
			this.view.setBtnGotoGraphDisable(false);
		});
		
		// load graph view
		// listener for goto graph button
		this.view.btnGotoGraphListener(e -> { 
			GraphView graphView = new GraphView();
			GraphModel graphModel = new GraphModel();
			
			GraphController graphController = new GraphController(graphView, graphModel, selectedFile, stage, mvs.matchedKeywords);

			Scene scene = new Scene(graphView.asParent(), 300, 300);

			stage.setScene(scene);
			stage.setTitle("XML Keyword Search System");
			stage.show();
		});
		
		this.view.btnBackListener(e -> { 
			ChooseSourceView chooseSourceView = new ChooseSourceView();
			ChooseSourceModel chooseSourceModel = new ChooseSourceModel();
			ChooseSourceController chooseSourceController = new ChooseSourceController(chooseSourceView, chooseSourceModel, stage);
			
			Scene scene = new Scene(chooseSourceView.asParent(), 300, 300);		// instantiate new scene for choose source page
			
			stage.setScene(scene);
			stage.setTitle("XML Keyword Search System");
			stage.show();
		});
	}
}
