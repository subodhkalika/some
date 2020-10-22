package application.Controller;
	
import java.io.File;

import application.Model.ChooseSourceModel;
import application.Model.MovieSearchModel;
import application.View.ChooseSourceView;
import application.View.MovieSearchView;
import application.Store.MoviesStore;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ChooseSourceController {

	private ChooseSourceView view;
	private ChooseSourceModel model;
	private Stage stage;
	MoviesStore hashMapStore = new MoviesStore();

	File selectedFile = null;
	
	public ChooseSourceController(ChooseSourceView view, ChooseSourceModel model, Stage stage) {
		this.view = view;
		this.model = model;
		this.stage = stage;
		
		this.view.btnSourceListener(e -> {
			FileChooser  file = new FileChooser();
			file.setTitle("Open File");		
			selectedFile = file.showOpenDialog(this.stage); 
			this.view.setSourceLabel(selectedFile.getName()); 
			this.view.setLoadButttonDisable(false);
		});

		this.view.btnLoadListener(e -> {
			this.view.clearTextBox();
			this.view.setGotoMovieDisable(false);
			String extractedContent = this.model.parseXMLFile(this.selectedFile, this.hashMapStore.movieTitles);
			this.view.addContentToTextBox(extractedContent);
		});
		
		this.view.btnGotoMovieListener(e -> { 
			MovieSearchView movieSearchView = new MovieSearchView();
			MovieSearchModel movieSearchModel = new MovieSearchModel();
			MovieSearchController movieSearchController = new MovieSearchController(movieSearchView, movieSearchModel, this.selectedFile, stage, this.hashMapStore.movieTitles);
			
			Scene scene = new Scene(movieSearchView.asParent(), 500, 500);
			
			stage.setScene(scene);
			stage.setTitle("XML Keyword Search System");
			stage.show();
		});	
	}
}