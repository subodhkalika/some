package application.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * View for Movie search page
 *
 * @author 	Subodh Kalika (102875446)
 * @author 	Sandesh Dhoju (102840091)
 * @version 2020.10.20
 */
public class MovieSearchView {
	
	private GridPane view;
	
	// View datamembers
	private HBox hboxSearchMovie;
	private HBox hboxActionButtons;
	private Label labelSearchKeyword;
	private TextField textFieldSearchKeyword;
	private Button btnSearchMovie;
	private TextArea textAreaSearchResult;
	private Button btnGotoGraph;
	private Button btnBack;

	/**
	 * Constructor for MovieSearchView
	 */
	public MovieSearchView() {
		createAndConfigurePane();
		createAndLayoutControls();
	}
	
	/**
	 * asParent <Parent> Method
	 *  
	 * @return view
	 */
	public Parent asParent() {
		return view;
	}
	
	/**
	 * Method to create layout for view
	 *
	 */
	private void createAndLayoutControls() {
		//View Components initialization
		labelSearchKeyword = new Label("Enter Search Keyword");
		textFieldSearchKeyword = new TextField();
		textFieldSearchKeyword.setPromptText("Enter keyword to search");
		btnSearchMovie = new Button("Search");
		textAreaSearchResult = new TextArea();
		btnGotoGraph = new Button("Goto graph Page");
		btnGotoGraph.setDisable(true);
		btnBack = new Button("Back");
		
		hboxSearchMovie = new HBox();
		hboxSearchMovie.setSpacing(20);
		hboxSearchMovie.getChildren().addAll(textFieldSearchKeyword, btnSearchMovie);
		
		hboxActionButtons = new HBox();
		hboxActionButtons .setSpacing(20);
		hboxActionButtons .getChildren().addAll(btnBack, btnGotoGraph);
		
		view.addRow(0,labelSearchKeyword);
		view.addRow(1,hboxSearchMovie);
		view.addRow(2,textAreaSearchResult);
		view.addRow(3,hboxActionButtons);
	}
	
	/**
	 * Method to create and configure grid pane 
	 *
	 */
	private void createAndConfigurePane() {
		view = new GridPane();
		view.setPadding(new Insets(10,10,10,10));
		view.setAlignment(Pos.CENTER);
		view.setHgap(5);
		view.setVgap(10);		
	}
	
	/**
	 * Method to disable/enable btnGotoGraph button
	 *
	 * @param boolean 		isDisable flag to disable/enable btnGotoGraph button
	 */
	public void setBtnGotoGraphDisable(Boolean isDisable) {
		btnGotoGraph.setDisable(isDisable);
	}
	
	/**
	 * Method to add text to movie results text area
	 *
	 * @param string 		content to be updated on textAreaSearchResult
	 */
	public void addToMovieResults(String content) {
		textAreaSearchResult.clear();
		textAreaSearchResult.setText(" ");
		textAreaSearchResult.setText(content);
	}

	/**
	 * Method to get search keyword value form  text field
	 *
	 * @return string
	 */
	public String getSearchKeyword() {
		return textFieldSearchKeyword.getText();
	}

	/**
	 * Method to clear movie results text area
	 *
	 */
	public void clearMovieResults() {
		textAreaSearchResult.setText("");
	}

	public TextArea getTextArea() {
		return textAreaSearchResult;
	}
	
	/**
	 * Set Listener for button search
	 *
	 * @param EventHandler<ActionEvent> 		listener event
	 */
	public void btnSearchMovieListener(EventHandler<ActionEvent> listener) {
		btnSearchMovie.setOnAction(listener);
	}
	
	/**
	 * Set Listener for button go to graph
	 *
	 * @param EventHandler<ActionEvent> 		listener event
	 */
	public void btnGotoGraphListener(EventHandler<ActionEvent> listener) {
		btnGotoGraph.setOnAction(listener);
	}
	
	/**
	 * Set Listener for back button
	 *
	 * @param EventHandler<ActionEvent> 		listener event
	 */
	public void btnBackListener(EventHandler<ActionEvent> listener) {
		btnBack.setOnAction(listener);
	}
}
