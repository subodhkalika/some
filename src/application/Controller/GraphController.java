package application.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import application.Model.GraphModel;
import application.View.BarChartView;
import application.View.GraphView;
import application.View.PieChartView;
import javafx.stage.Stage;

public class GraphController {
	private GraphView view;
	private GraphModel model;
	
	public GraphController(GraphView view, GraphModel model, File selectedFile, Stage stage, ArrayList<String> matchedKeywords) {
		this.view = view;
		this.model = model;

		HashMap<String, Integer> frequencyMap = this.model.findKeywordFrequency(selectedFile);
		ArrayList<String> sortedKeywords = this.model.getSortedKeywords(matchedKeywords, frequencyMap);
		
		this.view.btnBarChartListener(e -> {
			String selectedCriteria = this.view.getSelectedRadioBtnValue();
			ArrayList<String> topNkeyWords = this.model.getTopNKeywords(selectedCriteria, sortedKeywords);
			
			BarChartView barChartView = new BarChartView();
			barChartView.drawBarChart(topNkeyWords, frequencyMap);
		});

		this.view.btnPieChartListener(e -> {
			String selectedCriteria = this.view.getSelectedRadioBtnValue();
			ArrayList<String> topNkeyWords = this.model.getTopNKeywords(selectedCriteria, sortedKeywords);
			
			PieChartView pieChartView = new PieChartView();
			pieChartView.drawPieChart(topNkeyWords, frequencyMap);
		});
	}
}
