package com.packt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.util.*;
import java.util.function.*;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.scene.chart.*;
import java.util.stream.*;

public class BubbleChartDemo extends Application{
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws IOException {

		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(25, 25, 25, 25));

		final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Student");
        yAxis.setLabel("Marks");
        final BubbleChart<String,Number> bubbleChart = 
            new BubbleChart<>(xAxis,yAxis);

       	List<Marks> marks = getMarks();

		bubbleChart.getData().add(getSeries(
          "Unit Tests", marks, Marks::getUnitTests, 0.15
        ));

        bubbleChart.getData().add(getSeries(
          "Mid Term", marks, Marks::getMidTerm, 0.25
        ));
        bubbleChart.getData().add(getSeries(
          "Final Term", marks, Marks::getFinalTerm, 0.60
        ));

		gridPane.add(bubbleChart, 1, 1);
		
		Scene scene = new Scene(gridPane, 800, 600);
		stage.setTitle("Bubble Charts");
		stage.setScene(scene);
		stage.show();
	}

	private XYChart.Series<String,Number> getSeries(
		String seriesName
		List<Marks> data,
		Function<Marks, Double> extractor,
		Double contribution
	) throws IOException{
		XYChart.Series<String,Number>  series = new XYChart.Series<>();
        series.setName(seriesName);
        data.forEach(d -> {
        	Double bubbleRadius = 
        	  (contribution * extractor.apply(d))/10
        	series.getData().add(new XYChart.Data<String, Number>(
        		d.id, extractor.apply(d), bubbleRadius
        	));
        });
        return series;
	}
	
	private List<Marks> getMarks()
		throws IOException{
		Scanner reader = new Scanner(getClass()
			.getModule()
			.getResourceAsStream("com/packt/marks")
		);

		List<Marks> data = new LinkedList<>();
		while(reader.hasNext()){
			String line = reader.nextLine();
			String[] elements = line.split(",");
			Marks m = new Marks(elements);
			data.add(m);	
		}
		Collections.reverse(data);
		return data;
	}
}