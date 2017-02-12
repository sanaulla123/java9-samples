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

		final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Student");
        yAxis.setLabel("Marks");
        final BubbleChart<Number,Number> bubbleChart = 
            new BubbleChart<>(xAxis,yAxis);

       	List<Marks> marks = getMarks();

       	populateSeries(bubbleChart, marks);

		gridPane.add(bubbleChart, 1, 1);
		
		Scene scene = new Scene(gridPane, 800, 600);
		stage.setTitle("Bubble Charts");
		stage.setScene(scene);
		stage.show();
	}

	private void populateSeries(
		BubbleChart bubbleChart,
		List<Marks> marks
	){
		marks.forEach(m -> {
			XYChart.Series<Number,Number>  series = new XYChart.Series<>();
			series.setName("Student " + m.id);
			series.getData().add(new XYChart.Data<Number, Number>(
        		1, m.firstTest, 0.5
        	));
        	series.getData().add(new XYChart.Data<Number, Number>(
        		2, m.secondTest, 0.5
        	));
        	series.getData().add(new XYChart.Data<Number, Number>(
        		3, m.thirdTest, 0.5
        	));
        	series.getData().add(new XYChart.Data<Number, Number>(
        		4, m.fourthTest, 0.5
        	));
        	series.getData().add(new XYChart.Data<Number, Number>(
        		5, m.midTerm, 1
        	));
        	series.getData().add(new XYChart.Data<Number, Number>(
        		6, m.finalTerm, 2
        	));
        	bubbleChart.getData().add(series);
		});
	}

	private XYChart.Series<Number,Number> getSeries(
		String seriesName,
		List<Marks> data,
		Function<Marks, Double> extractor,
		Double contribution
	) throws IOException{
		XYChart.Series<Number,Number>  series = new XYChart.Series<>();
        series.setName(seriesName);
        data.forEach(d -> {
        	Double bubbleRadius = 
        	  ((contribution * extractor.apply(d)) * 1 ) / 100;
        	series.getData().add(new XYChart.Data<Number, Number>(
        		d.id, extractor.apply(d), 1
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
		int id = 1;
		while(reader.hasNext()){
			String line = reader.nextLine();
			String[] elements = line.split(",");
			Marks m = new Marks(id, elements);
			data.add(m);	
			id++;
		}
		return data;
	}
}