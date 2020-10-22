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
	private Stage stage;
	
	MoviesStore hashMapStore = new MoviesStore();

	File selectedFile = null;

	public MovieSearchController(MovieSearchView view, MovieSearchModel model, File selectedFile, Stage stage, HashMap<String, ArrayList<String>> movieTitles) {
		this.view = view;
		this.model = model;
		this.stage = stage;

		this.view.btnSearchMovieListener(e -> {
			String keyword = this.view.getSearchKeyword();
			this.view.clearMovieResults();
			System.out.println(this.view.getTextAreaSearchResult().getText());

			ArrayList<String> matchedMovieTitles = this.model.parseXMLFile(selectedFile, keyword);
			for (String movieTitle : matchedMovieTitles) {
				this.view.addToMovieResults(movieTitle);
			}
		});	
		
		this.view.btnGotoGraphListener(e -> { 
			GraphView graphView = new GraphView();
			GraphModel graphModel = new GraphModel();
			GraphController graphController = new GraphController(graphView, graphModel, this.selectedFile, stage, this.hashMapStore.movieTitles);

			Scene scene = new Scene(graphView.asParent(), 500, 500);

			stage.setScene(scene);
			stage.setTitle("XML Keyword Search System");
			stage.show();
		});	
	}
}
