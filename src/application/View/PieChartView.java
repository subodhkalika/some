package application.View;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;
import javafx.stage.Stage;

public class PieChartView {
	public void drawPieChart(ArrayList<String> keyWords, HashMap<String, Integer> frequencyMap) {
		try {
			ObservableList<Data> list = FXCollections.observableArrayList();
	
			for(String kw: keyWords) {
				list.add(new PieChart.Data(kw, frequencyMap.get(kw)));
			}

			PieChart pieChart = new PieChart();
			pieChart.setData(list);
			pieChart.setLegendSide(Side.LEFT);
			pieChart.setTitle("Class Frequency Pie Chart");
			pieChart.setClockwise(false);
	
			Group root = new Group();
			root.getChildren().add(pieChart);
			Scene sc = new Scene(root,500,400);
			Stage stage1 = new Stage();
			stage1.setScene(sc);
			stage1.setTitle("Pie Chart");
			stage1.show();
		} catch(Exception e1) {
			e1.printStackTrace();
		}
	}
}
