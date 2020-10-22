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
	
	public ChooseSourceView() {
		createAndConfigurePane();
		createAndLayoutControls();
	}
	
	public Parent asParent() {
		return view;
	}
	
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
	
	public TextArea getTxtr() {
		return txtR;
	}
	
		
	public void setSumLabel(int solution) {
		sumLabel.setText(Integer.toString(solution));
	}
	
	public void setSourceLabel(String label) {
		lblSource.setText(label);
	}
		
	public void setLoadButttonDisable(Boolean isDisable) {
		btnLoad.setDisable(isDisable);
	}
	
	public void setGotoMovieDisable(Boolean isDisable) {
		btnGotoMovie.setDisable(isDisable);
	}

	public void clearTextBox() {
		txtR.setText("");
	}

	public void addContentToTextBox(String content, Boolean withNewLine) {
		String textBoxAdditionalcontent = withNewLine ? "\n" + content : content;
		txtR.setText(txtR.getText() + textBoxAdditionalcontent);
	}
	
	public void addContentToTextBox(String content) {
		this.addContentToTextBox(content, false);
	}

	public void btnSourceListener(EventHandler<ActionEvent> listener) {
		btnSource.setOnAction(listener);
	}
	
	public void btnLoadListener(EventHandler<ActionEvent> listener) {
		btnLoad.setOnAction(listener);
	}
	
	public void btnGotoMovieListener(EventHandler<ActionEvent> listener) {
		btnGotoMovie.setOnAction(listener);
	}
	
}