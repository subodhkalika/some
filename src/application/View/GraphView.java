package application.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * View for Graph page
 *
 * @author 	Subodh Kalika (102875446)
 * @author 	Sandesh Dhoju (102840091)
 * @version 2020.10.20
 */
public class GraphView {
	private GridPane view;

	private HBox hboxGraphButtons;
	private Button btnBarChart;
	private Button btnPieChart;
	private Button btnBack;
	private Label labelSelectChart;
	private ToggleGroup group;
	private RadioButton rb1; 
	private RadioButton rb2; 
	private RadioButton rb3; 
	private RadioButton rb4; 
	
	/**
	 * Constructor for GraphView
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
	 *
	 */
	private void createAndLayoutControls() {
		//View Components initialization
		//4 radio buttons
		labelSelectChart = new Label("Select Chart");
		
		//graph button
		btnBarChart = new Button("Bar Chart");
		btnPieChart = new Button("Pie Chart");
		
		btnBack = new Button("Back");

		group = new ToggleGroup();

		rb1 = new RadioButton("Top-3 correlated keywords");
		rb1.setToggleGroup(group);
		rb1.setSelected(true);
		rb1.setUserData("TOP_3");
		
		rb2 = new RadioButton("Top-5 correlated keywords");
		rb2.setToggleGroup(group);
		rb2.setUserData("TOP_5");
		
		rb3 = new RadioButton("Top-8 correlated keywords");
		rb3.setToggleGroup(group);
		rb3.setUserData("TOP_8");
		
		rb4 = new RadioButton("Top-10 correlated keywords");
		rb4.setToggleGroup(group);
		rb4.setUserData("TOP_10");

		hboxGraphButtons = new HBox();
		hboxGraphButtons.setSpacing(20);
		hboxGraphButtons.getChildren().addAll(btnBarChart, btnPieChart);
		
		view.addRow(0, rb1);
		view.addRow(1, rb2);
		view.addRow(2, rb3);
		view.addRow(3, rb4);
		view.addRow(4,labelSelectChart);
		view.addRow(5,hboxGraphButtons);
		view.addRow(6, btnBack);
	}
	
	/**
	 * Method to create and configure grid pane 
	 *
	 */
	private void createAndConfigurePane() {
		view = new GridPane();
		view.setPadding(new Insets(10,10,10,10));
		view.setAlignment(Pos.CENTER);
		view.setHgap(5);
		view.setVgap(10);		
	}
	
	/**
	 * Method to get radio button value
	 *
	 * @return string
	 */
	public String getSelectedRadioBtnValue() {
		return this.group.getSelectedToggle().getUserData().toString();
	}
	
	/**
	 * Set Listener for button bar chart
	 *
	 * @param EventHandler<ActionEvent> 		listener event
	 */
	public void btnBarChartListener(EventHandler<ActionEvent> listener) {
		btnBarChart.setOnAction(listener);
	}
	
	/**
	 * Set Listener for button pie chart
	 *
	 * @param EventHandler<ActionEvent> 		listener event
	 */
	public void btnPieChartListener(EventHandler<ActionEvent> listener) {
		btnPieChart.setOnAction(listener);
	}
	
	/**
	 * Set Listener for back button
	 *
	 * @param EventHandler<ActionEvent> 		listener event
	 */
	public void btnBackListener(EventHandler<ActionEvent> listener) {
		btnBack.setOnAction(listener);
	}
}
