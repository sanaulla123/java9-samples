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
import com.packt.processor.*;

public class ScatterChartDemo extends Application{
	
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

		StudentDataProcessor sdp = new StudentDataProcessor();
		List<Student> students = sdp.loadStudent();
		System.out.println("students : " + students.size());



		final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Age");
        yAxis.setLabel("Marks");
        final ScatterChart<Number,Number> scatterChart = 
            new ScatterChart<>(xAxis,yAxis);
        scatterChart.getData().add(getSeries(
        	students, 
        	"G1",
        	Student::getFirstTermGrade
        ));
        scatterChart.getData().add(getSeries(
        	students, 
        	"G2",
        	Student::getSecondTermGrade
        ));
        scatterChart.getData().add(getSeries(
        	students, 
        	"Final",
        	Student::getFinalGrade
        ));
        
		gridPane.add(scatterChart, 1, 1);
		
		Scene scene = new Scene(gridPane, 800, 600);
		stage.setTitle("Bubble Charts");
		stage.setScene(scene);
		stage.show();
	}

	private XYChart.Series<Number, Number> getSeries(
		List<Student> data,
		String seriesName,
		Function<Student, Number> extractor
	){
		XYChart.Series<Number,Number> series = 
		  new XYChart.Series<>();
		series.setName(seriesName);
		data.forEach(s -> {
			series.getData().add(new XYChart.Data<Number, Number>(
        		s.age, extractor.apply(s)
        	));
		});
		return series;
	}
}