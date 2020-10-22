package application.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import application.Model.GraphModel;
import application.Model.MovieSearchModel;
import application.View.GraphView;
import application.View.MovieSearchView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GraphController {
	private GraphView view;
	private GraphModel model;
	private Stage stage;
	
	public GraphController(GraphView view, GraphModel model, File selectedFile, Stage stage, HashMap<String, ArrayList<String>> movieTitles) {
		this.view = view;
		this.model = model;
		this.stage = stage;
		
		
	}
}
