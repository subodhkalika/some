package application.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class GraphView {
	private GridPane view;

	private TextField xField;
	private TextField yField;

	private HBox hboxGraphButtons;
	private Button btnBarChart;
	private Button btnPieChart;
	private Label labelSelectChart;

	/**
	 * Constructor
	 */
	public GraphView() {
		createAndConfigurePane();
		createAndLayoutControls();
	}
	
	/**
	 * asParent <Parent> Method
	 *  
	 * @return view
	 */
	public Parent asParent() {
		return view;
	}
	
	/**
	 * Method to create layout for view
	 */
	private void createAndLayoutControls() {
		//View Components initialization
		//4 radio buttons
		labelSelectChart = new Label("Select Chart");
		
		//2graph button
		btnBarChart = new Button("Bar Chart");
		btnPieChart = new Button("Pie Chart");
		//graph

		final ToggleGroup group = new ToggleGroup();

		RadioButton rb1 = new RadioButton("Top-3 correlated keywords");
		rb1.setToggleGroup(group);
		rb1.setSelected(true);

		RadioButton rb2 = new RadioButton("Top-5 correlated keywords");
		rb2.setToggleGroup(group);
		    
		RadioButton rb3 = new RadioButton("Top-8 correlated keywords");
		rb3.setToggleGroup(group);

		RadioButton rb4 = new RadioButton("Top-10 correlated keywords");
		rb4.setToggleGroup(group);

		hboxGraphButtons = new HBox();
		hboxGraphButtons.setSpacing(20);
		hboxGraphButtons.getChildren().addAll(btnBarChart, btnPieChart);
		
		view.addRow(0, rb1);
		view.addRow(1, rb2);
		view.addRow(2, rb3);
		view.addRow(3, rb4);
		view.addRow(4,labelSelectChart);
		view.addRow(5,hboxGraphButtons);
	}
	
	/**
	 * Method to create and configure grid pane 
	 */
	private void createAndConfigurePane() {
		view = new GridPane();
		view.setPadding(new Insets(10,10,10,10));
		view.setAlignment(Pos.CENTER);
		view.setHgap(5);
		view.setVgap(10);		
	}
	
	public int getXField() {
		return Integer.parseInt(xField.getText());
	}
	
	public int getYField() {
		return Integer.parseInt(yField.getText());
	}
}
