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
public class BarChartDemo extends Application{

	
	@Override
	public void start(Stage stage) throws IOException {
		StudentDataProcessor sdp = new StudentDataProcessor();
		List<Student> students = sdp.loadStudent();
		System.out.println("students : " + students.size());
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(25, 25, 25, 25));

		BarChart<String, Number> avgGradeByMotherEdu = 
			getAvgGradeByEducationBarChart(
				students, 
				Student::getMotherEducation
			);
		avgGradeByMotherEdu.setTitle("Average grade by Mother's Education");
		gridPane.add(avgGradeByMotherEdu, 1,1);

		BarChart<String, Number> avgGradeByFatherEdu = 
			getAvgGradeByEducationBarChart(
				students, 
				Student::getFatherEducation
			);
		avgGradeByFatherEdu.setTitle("Average grade by Father's Education");
		gridPane.add(avgGradeByFatherEdu, 2,1);

		Scene scene = new Scene(gridPane, 800, 600);
		stage.setTitle("Bar Charts");
		stage.setScene(scene);
		stage.show();
	}

	private BarChart<String, Number> getAvgGradeByEducationBarChart(
		List<Student> students,
		Function<Student, ParentEducation> classifier
	){
        Map<ParentEducation, IntSummaryStatistics> g1Average = 
        	students.stream().collect(
    			Collectors.groupingBy(
    				classifier,
    				Collectors.summarizingInt(Student::getFirstTermGrade)
    			)
    		);
        Map<ParentEducation, IntSummaryStatistics> g2Average = 
        	students.stream().collect(
    			Collectors.groupingBy(
    				classifier,
    				Collectors.summarizingInt(Student::getSecondTermGrade)
    			)
        	);
       	Map<ParentEducation, IntSummaryStatistics> finalAverage = 
        	students.stream().collect(
    			Collectors.groupingBy(
    				classifier,
    				Collectors.summarizingInt(Student::getFinalGrade)
    			)
    		);
 		
 		final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<>(xAxis,yAxis);
        xAxis.setLabel("Education");
        yAxis.setLabel("Grade");

        XYChart.Series g1Series = new XYChart.Series();
        g1Series.setName("G1");
        g1Average.forEach((k, v) -> {
        	g1Series.getData().add(new XYChart.Data(k.toString(),v.getAverage()));
        });
        
        XYChart.Series g2Series = new XYChart.Series();
        g2Series.setName("G2");
        g2Average.forEach((k, v) -> {
        	g2Series.getData().add(new XYChart.Data(k.toString(),v.getAverage()));
        });
        
        XYChart.Series finalSeries = new XYChart.Series();
        finalSeries.setName("Final");
        finalAverage.forEach((k, v) -> {
        	finalSeries.getData().add(new XYChart.Data(k.toString(),v.getAverage()));
        });
        bc.getData().addAll(g1Series, g2Series, finalSeries);
        return bc;
	}


	public static void main(String[] args) {
		Application.launch(args);
	}

	
}