package application;
	
import application.Controller.ChooseSourceController;
import application.Model.ChooseSourceModel;
import application.View.ChooseSourceView;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 * Main Class
 * @author Sandesh Dhoju (102840091)
 * @author Subodh Kalika (102875446)
 * 
 * @version 2020.10.20
 */
public class XMLKeywordSearchApplication extends Application {
	@Override
	public void start(Stage stage) {
		try {
			ChooseSourceView chooseSourceView = new ChooseSourceView();
			ChooseSourceModel chooseSourceModel = new ChooseSourceModel();
			ChooseSourceController chooseSourceController = new ChooseSourceController(chooseSourceView, chooseSourceModel, stage);
			
			Scene scene = new Scene(chooseSourceView.asParent(), 300, 300);
			
			stage.setScene(scene);
			stage.setTitle("XML Keyword Search System");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
