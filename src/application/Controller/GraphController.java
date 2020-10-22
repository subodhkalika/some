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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;
import javafx.stage.Stage;

public class GraphController {
	private GraphView view;
	private GraphModel model;
	private Stage stage;
	
	public GraphController(GraphView view, GraphModel model, File selectedFile, Stage stage, String keyword) {
		this.view = view;
		this.model = model;
		this.stage = stage;
		
		this.view.btnBarChartListener(e -> {
			try {
//				this.view.getValue();
				int frequencyValue = 3;
				HashMap<String, Integer> frequencyMap = this.model.findKeywordFrequency(selectedFile, keyword, frequencyValue);
				BarChartView barChartView = new BarChartView();
				barChartView.drawBarChart(frequencyMap);
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		this.view.btnPieChartListener(e -> {
			int frequencyValue = 3;
			HashMap<String, Integer> frequencyMap = this.model.findKeywordFrequency(selectedFile, keyword, frequencyValue);
			PieChartView pieChartView = new PieChartView();
			pieChartView.drawPieChart(frequencyMap);
		});
	}
}
