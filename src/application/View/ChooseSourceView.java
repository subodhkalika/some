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
 * View for Choose Source page
 *
 * @author 	Subodh Kalika (102875446)
 * @author 	Sandesh Dhoju (102840091)
 * @version 2020.10.20
 */
public class ChooseSourceView {

	private GridPane view;
	private TextField xField;
	private TextField yField;
	private Label sumLabel;
	
	private Button btnSource;
	private Button btnLoad;
	private Button btnGotoMovie;
	private Label lblSource;
	private HBox hboxSource;
	private TextArea txtR;
	private HBox hboxParsing;
	private HBox hboxGotoMovie;
	
	/**
	 * Constructor for ChooseSourceView
	 */
	public ChooseSourceView() {
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
		btnSource = new Button("Choose Source");
		lblSource = new Label("");
		hboxSource = new HBox(btnSource,lblSource );
		hboxSource.setSpacing(10);

		btnLoad = new Button("Load");
		btnLoad.setDisable(true);

		hboxParsing = new HBox(btnLoad );
		hboxParsing.setSpacing(10);

		txtR = new TextArea();
		txtR.setEditable(false);

		btnGotoMovie = new Button("Goto Search Movie Page");
		btnGotoMovie.setDisable(true);

		hboxGotoMovie = new HBox(btnGotoMovie);
		hboxGotoMovie.setSpacing(10);
		
		view.addRow(0,hboxSource);
		view.addRow(1,hboxParsing);
		view.addRow(2,txtR);
		view.addRow(3,hboxGotoMovie);
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
	 * Method to get txtR text area
	 *
	 * @return TextArea
	 */
	public TextArea getTxtr() {
		return txtR;
	}
	
	/**
	 * Method to set source label
	 *
	 * @param string 		label
	 */
	public void setSourceLabel(String label) {
		lblSource.setText(label);
	}

	/**
	 * Method to disable/enable load button
	 *
	 * @param boolean 		isDisable flag to disable/enable load button
	 */	
	public void setLoadButttonDisable(Boolean isDisable) {
		btnLoad.setDisable(isDisable);
	}
	
	/**
	 * Method to disable/enable btnGotoMovie button
	 *
	 * @param boolean 		isDisable flag to disable/enable btnGotoMovie button
	 */
	public void setGotoMovieDisable(Boolean isDisable) {
		btnGotoMovie.setDisable(isDisable);
	}

	/**
	 * Method to clear text area
	 *
	 */
	public void clearTextBox() {
		txtR.setText("");
	}

	/**
	 * Method to add content in the text box with new line
	 *
	 * @param string 		content to be added to text box
	 * @param boolean 		is new line to be added with content
	 */
	public void addContentToTextBox(String content, Boolean withNewLine) {
		String textBoxAdditionalcontent = withNewLine ? "\n" + content : content;
		txtR.setText(txtR.getText() + textBoxAdditionalcontent);
	}
	
	/**
	 * Method to add content in the text box
	 *
	 * @param string 		content to be added to text box
	 */
	public void addContentToTextBox(String content) {
		this.addContentToTextBox(content, false);
	}

	/**
	 * Set Listener for button source
	 *
	 * @param EventHandler<ActionEvent> 		listener event
	 */
	public void btnSourceListener(EventHandler<ActionEvent> listener) {
		btnSource.setOnAction(listener);
	}
	
	/**
	 * Set Listener for button load
	 *
	 * @param EventHandler<ActionEvent> 		listener event
	 */
	public void btnLoadListener(EventHandler<ActionEvent> listener) {
		btnLoad.setOnAction(listener);
	}
	
	/**
	 * Set Listener for button goto movie
	 *
	 * @param EventHandler<ActionEvent> 		listener event
	 */
	public void btnGotoMovieListener(EventHandler<ActionEvent> listener) {
		btnGotoMovie.setOnAction(listener);
	}
	
}