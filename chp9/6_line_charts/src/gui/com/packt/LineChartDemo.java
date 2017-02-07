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

public class LineChartDemo extends Application{
	
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

		
		LineChart<Number, Number> avgGradeByAge = 
			getAvgGradeByAgeLineChart(students);
		avgGradeByAge.setTitle("Average grade by Student's age");
		gridPane.add(avgGradeByAge, 1,1);

		Scene scene = new Scene(gridPane, 800, 600);
		stage.setTitle("Pie Charts");
		stage.setScene(scene);
		stage.show();
	}

	private LineChart<Number, Number> getAvgGradeByAgeLineChart(
		List<Student> students
	){
    
 		final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<Number,Number> lineChart = 
            new LineChart<>(xAxis,yAxis);
        xAxis.setLabel("Age");
        yAxis.setLabel("Final Grade");

		lineChart.getData().add(getSeries(
        	"G1", students, Student::getFirstTermGrade
        ));
        lineChart.getData().add(getSeries(
        	"G2", students, Student::getSecondTermGrade
        ));
        /*lineChart.getData().add(getSeries(
        	"G1", 
        	getGradeSummaryByStudentAge(students, 
        		Student::getFirstTermGrade)
        ));
        lineChart.getData().add(getSeries(
        	"G2", 
        	getGradeSummaryByStudentAge(students, 
        		Student::getSecondTermGrade)
        ));*/
        /*lineChart.getData().add(getSeries(
        	"Final", 
        	getGradeSummaryByStudentAge(students, 
        		Student::getFinalGrade)
        ));*/
     
        return lineChart;
	}

	private Map<Integer, IntSummaryStatistics> getGradeSummaryByStudentAge(
		List<Student> students,
		ToIntFunction<Student> mapper
	){
		Map<Integer, IntSummaryStatistics> statistics = 
        	students.stream().collect(
    			Collectors.groupingBy(
    				Student::getAge,
    				Collectors.summarizingInt(mapper)
    			)
    		);
    	return statistics;
	}
	/*private XYChart.Series<Number,Number> getSeries(
		String seriesName,
		Map<Integer, IntSummaryStatistics> statistics
	){
		XYChart.Series<Number,Number>  series = new XYChart.Series<>();
        series.setName(seriesName);
        statistics.forEach((k, v) -> {
        	series.getData().add(new XYChart.Data<Number, Number>(k, v.getAverage()));
        });
        return series;
	}*/

	private XYChart.Series<Number,Number> getSeries(
		String seriesName, List<Student> students,
		Function<Student, Integer> extractor
	){
		XYChart.Series<Number,Number>  series = new XYChart.Series<>();
        series.setName(seriesName);
        students.forEach(s -> {
        	series.getData().add(new XYChart.Data<Number, Number>(
        		s.getFinalGrade(), extractor.apply(s)
        	));
        });
        return series;
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	
}