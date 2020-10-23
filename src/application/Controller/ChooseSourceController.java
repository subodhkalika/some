package application.Controller;

import java.io.File;

import application.Model.ChooseSourceModel;
import application.Model.MovieSearchModel;
import application.View.ChooseSourceView;
import application.View.MovieSearchView;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Controller for choose source page
 *
 * @author 	Subodh Kalika (102875446)
 * @author 	Sandesh Dhoju (102840091)
 * @version 2020.10.20
 */
public class ChooseSourceController {

	private ChooseSourceView view;
	private ChooseSourceModel model;
	private Stage stage;

	File selectedFile = null;

	/**
	 * Constructor for ChooseSourceController
	 *
	 * @param ChooseSourceView 			view
	 * @param ChooseSourceModel 		model
	 * @param Stage 					stage
	 */
	public ChooseSourceController(ChooseSourceView view, ChooseSourceModel model, Stage stage) {
		this.view = view;
		this.model = model;
		this.stage = stage;

		// listener for choose source button
		this.view.btnSourceListener(e -> {
			FileChooser file = new FileChooser();
			file.setTitle("Open File");
			selectedFile = file.showOpenDialog(this.stage);
			this.view.setSourceLabel(selectedFile.getName());
			this.view.setLoadButttonDisable(false);
		});

		// parse and load text into text area
		// listener for load button
		this.view.btnLoadListener(e -> {
			this.view.clearTextBox();
			this.view.setGotoMovieDisable(false);
			String extractedContent = this.model.parseXMLFile(this.selectedFile);
			this.view.addContentToTextBox(extractedContent);
		});

		// load movie search page 
		// listener for goto movie page button
		this.view.btnGotoMovieListener(e -> {
			MovieSearchView movieSearchView = new MovieSearchView();
			MovieSearchModel movieSearchModel = new MovieSearchModel();
			MovieSearchController movieSearchController = new MovieSearchController(movieSearchView, movieSearchModel,
					this.selectedFile, stage);

			Scene scene = new Scene(movieSearchView.asParent(), 300, 300);

			stage.setScene(scene);
			stage.setTitle("XML Keyword Search System");
			stage.show();
		});
	}
}