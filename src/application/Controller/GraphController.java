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
		
		this.view.btnBarChartListener(e -> {
			try {
				String selectedCriteria = this.view.getSelectedRadioBtnValue();
				HashMap<String, Integer> frequencyMap = this.model.findKeywordFrequency(selectedFile);
				BarChartView barChartView = new BarChartView();
				barChartView.drawBarChart(frequencyMap);
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		this.view.btnPieChartListener(e -> {
			String selectedCriteria = this.view.getSelectedRadioBtnValue();
			HashMap<String, Integer> frequencyMap = this.model.findKeywordFrequency(selectedFile);
			PieChartView pieChartView = new PieChartView();
			pieChartView.drawPieChart(frequencyMap);
		});
	}
}
