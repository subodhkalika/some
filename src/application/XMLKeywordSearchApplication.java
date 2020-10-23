package application;
	
import application.Controller.ChooseSourceController;
import application.Model.ChooseSourceModel;
import application.View.ChooseSourceView;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 * XMLKeywordSearchApplication Class
 *
 * @author 	Subodh Kalika (102875446)
 * @author 	Sandesh Dhoju (102840091)
 * @version 2020.10.20
 */
public class XMLKeywordSearchApplication extends Application {
	
	/**
	 * start method
	 *
	 * @param Stage 	stage
	 */
	@Override
	public void start(Stage stage) {
		try {
			ChooseSourceView chooseSourceView = new ChooseSourceView();
			ChooseSourceModel chooseSourceModel = new ChooseSourceModel();
			ChooseSourceController chooseSourceController = new ChooseSourceController(chooseSourceView, chooseSourceModel, stage);
			
			Scene scene = new Scene(chooseSourceView.asParent(), 300, 300);		// instantiate new scene for choose source page
			
			stage.setScene(scene);
			stage.setTitle("XML Keyword Search System");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Main method to launch the application
	 *
	 * @param args 		command line argument
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
