package application.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class MovieSearchView {
	
	private GridPane view;
	private TextField xField;
	private TextField yField;
	
	//label
	private HBox hboxSearchMovie;
	private HBox hboxActionButtons;
	private Label labelSearchKeyword;
	private TextField textFieldSearchKeyword;
	private Button btnSearchMovie;
	private TextArea textAreaSearchResult;
	private Button btnGotoGraph;

	/**
	 * Constructor
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
	 */
	private void createAndLayoutControls() {
		//View Components initialization
		labelSearchKeyword = new Label("Enter Search Keyword");
		textFieldSearchKeyword = new TextField();
		textFieldSearchKeyword.setPromptText("Enter keyword to search");
		btnSearchMovie = new Button("Search");
		textAreaSearchResult = new TextArea();
		btnGotoGraph = new Button("Goto graph Page");

		hboxSearchMovie = new HBox();
		hboxSearchMovie.setSpacing(20);
		hboxSearchMovie.getChildren().addAll(textFieldSearchKeyword, btnSearchMovie);
		
		hboxActionButtons = new HBox();
		hboxActionButtons .setSpacing(20);
		hboxActionButtons .getChildren().addAll(btnGotoGraph);
		
		view.addRow(0,labelSearchKeyword);
		view.addRow(1,hboxSearchMovie);
		view.addRow(2,textAreaSearchResult);
		view.addRow(3,hboxActionButtons);
	}
	
	/**
	 * Method to create and configure grid pane 
	 */
	private void createAndConfigurePane() {
		view = new GridPane();
		view.setPadding(new Insets(10,10,10,10));
		view.setAlignment(Pos.CENTER);
		view.setHgap(5);
		view.setVgap(10);		
	}
	
	public int getXField() {
		return Integer.parseInt(xField.getText());
	}
	
	public int getYField() {
		return Integer.parseInt(yField.getText());
	}
	
	public TextArea getTextAreaSearchResult() {
		return textAreaSearchResult;
	}
	
	public void addToMovieResults(String content) {
		textAreaSearchResult.setText(textAreaSearchResult.getText() + content + "\n");
	}

	public String getSearchKeyword() {
		return textFieldSearchKeyword.getText();
	}

	public void clearMovieResults() {
		textAreaSearchResult.setText("");
	}

	public void btnSearchMovieListener(EventHandler<ActionEvent> listener) {
		btnSearchMovie.setOnAction(listener);
	}
	
	public void btnGotoGraphListener(EventHandler<ActionEvent> listener) {
		btnGotoGraph.setOnAction(listener);
	}
	
}
