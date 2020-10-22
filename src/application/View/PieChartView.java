package application.View;

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

public class PieChartView {
	public void drawPieChart() {
		try {
			ObservableList<Data> list = FXCollections.observableArrayList();
	
			list.addAll(new PieChart.Data("Iris-setosa", 12), 
						new PieChart.Data("Iris-versicolor", 14),
						new PieChart.Data("Iris-virginica", 15));
	
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
