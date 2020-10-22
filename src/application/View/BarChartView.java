package application.View;

import java.util.HashMap;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BarChartView {
	public void drawBarChart(HashMap<String, Integer> freqyencyMap) {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Search Keyword");
		yAxis.setLabel("Frequency");

		BarChart<String,Integer> bar = new BarChart(xAxis,yAxis);
		bar.setTitle("Search Frequency Bar Chart");

		XYChart.Series<String, Integer> series = new XYChart.Series<>();

		//do dynamic using freqyencyMap
		series.getData().add(new XYChart.Data("Iris-setosa",12));
		series.getData().add(new XYChart.Data("Iris-versicolor",15));	
		series.getData().add(new XYChart.Data("Iris-virginica",12));	
		
		series.setName("Frequency");

		bar.getData().add(series);
		Group root = new Group(bar);
		//root.getChildren().add(bar);
		Scene sc = new Scene(root,500,400);
		Stage stage1 = new Stage();
		stage1.setTitle("Bar Chart");
		stage1.setScene(sc);
		stage1.show();
	}
}
