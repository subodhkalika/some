package application.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import application.Model.GraphModel;
import application.Model.MovieSearchModel;
import application.View.BarChartView;
import application.View.GraphView;
import application.View.MovieSearchView;
import application.View.PieChartView;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controller for graph page
 *
 * @author 	Subodh Kalika (102875446)
 * @author 	Sandesh Dhoju (102840091)
 * @version 2020.10.20
 */
public class GraphController {
	private GraphView view;
	private GraphModel model;
	
	/**
	 * Constructor for GraphController
	 *
	 * @param GraphView 			view
	 * @param GraphModel 			model
	 * @param File 					selectedFile
	 * @param Stage 				stage
	 * @param ArrayList<String> 	matchedKeywords
	 */
	public GraphController(GraphView view, GraphModel model, File selectedFile, Stage stage, ArrayList<String> matchedKeywords) {
		this.view = view;
		this.model = model;

		HashMap<String, Integer> frequencyMap = this.model.findKeywordFrequency(selectedFile);
		ArrayList<String> sortedKeywords = this.model.getSortedKeywords(matchedKeywords, frequencyMap);
		
		// load bar chart view
		// listener for bar chart button
		this.view.btnBarChartListener(e -> {
			String selectedCriteria = this.view.getSelectedRadioBtnValue();
			ArrayList<String> topNkeyWords = this.model.getTopNKeywords(selectedCriteria, sortedKeywords);
			
			BarChartView barChartView = new BarChartView();
			barChartView.drawBarChart(topNkeyWords, frequencyMap);
		});

		// load pie chart view
		// listener for pie chart button
		this.view.btnPieChartListener(e -> {
			String selectedCriteria = this.view.getSelectedRadioBtnValue();
			ArrayList<String> topNkeyWords = this.model.getTopNKeywords(selectedCriteria, sortedKeywords);
			
			PieChartView pieChartView = new PieChartView();
			pieChartView.drawPieChart(topNkeyWords, frequencyMap);
		});
		
		this.view.btnBackListener(e -> { 
			MovieSearchView movieSearchView = new MovieSearchView();
			MovieSearchModel movieSearchModel = new MovieSearchModel();
			MovieSearchController movieSearchController = new MovieSearchController(movieSearchView, movieSearchModel,
					selectedFile, stage);

			Scene scene = new Scene(movieSearchView.asParent(), 300, 300);

			stage.setScene(scene);
			stage.setTitle("XML Keyword Search System");
			stage.show();
		});
	}
}
