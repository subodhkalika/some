package application.View;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * View for Bar chart
 *
 * @author 	Subodh Kalika (102875446)
 * @author 	Sandesh Dhoju (102840091)
 * @version 2020.10.20
 */
public class BarChartView {

	/**
	 * method to draw bar chart
	 *
	 * @param ArrayList<String> 			keywords
	 * @param HashMap<String, Integer> 		frequencyMap
	 */
	public void drawBarChart(ArrayList<String> keywords, HashMap<String, Integer> frequencyMap) {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Search Keyword");
		yAxis.setLabel("Frequency");

		BarChart<String,Integer> bar = new BarChart(xAxis,yAxis);
		bar.setTitle("Search Frequency Bar Chart");

		XYChart.Series<String, Integer> series = new XYChart.Series<>();

		//do dynamic using freqyencyMap
		for(String kw: keywords) {
			series.getData().add(new XYChart.Data(kw, frequencyMap.get(kw)));
		}
		
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
