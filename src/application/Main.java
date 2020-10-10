package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.HBox;


/* Name: Jack Oporto
 * Class: CEN 3024C
 * Professor Dhrgam Al Kafaf
 * Assignment: Module 5, Documentation
 * Date completed: October 10, 2020
 * 
 * Summary:
 * This program demonstrates the differences in runtime performance between
 * an iterative and recursive function. While recursive functions are good
 * for most tasks, iterative functions run faster when dealing with enormous
 * numbers.
 * 
 * The enormous numbers in this example use the Fibonacci sequence.
 * 
 * On run, the program will run calculations for the given number of times
 * to calculate a Fibonacci number (40). Once it has completed both recursive
 * and iterative calculations, a graph will display the milliseconds it took to
 * calculate the number at each index.
 */



public class Main extends Application {
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		HBox root = new HBox();
		Scene scene = new Scene(root, 600, 400);
		
		NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel("Fib index");
		
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Milliseconds to calculate ");
		
		LineChart lineChart = new LineChart(xAxis, yAxis);
		lineChart.setTitle("Recursive vs iterative: Fibonacci ");
		
		//XYChart.Series<String, Number> data = new XYChart.Series<>();
		//data.setName("Fibonacci sequence");
		
		
		XYChart.Series series1 = new XYChart.Series();
		series1.setName("Recursive");
		
		XYChart.Series series2 = new XYChart.Series();
		series2.setName("Iterative");
		
		for(int i = 0; i<=40 ; i++) {
			series1.getData().add(new XYChart.Data(i, getRecTime(i)));
			series2.getData().add(new XYChart.Data(i, getIterTime(i)));
		}
		
		lineChart.getData().addAll(series1, series2);
		root.getChildren().add(lineChart);
		
		primaryStage.setTitle("Fibbonacci sequence Jack Oporto 2020");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//THE FIB FUNCTIONS
	
	//RECURSIVE (Calls itself)
	public static long fibRecursive(long index) {
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            return fibRecursive(index - 1) + fibRecursive(index - 2);
        }
    }
	
	//ITERATIVE
	public static long fibIterative(long index) {
		long var1 = 0, var2 = 1;
		long addedSum = 0;
		// Fibonacci series formation loop
		for (int i = 2; i <= index; ++i){
			addedSum = var1 + var2;
			var1 = var2;
			var2 = addedSum;
		}
		return addedSum;
	}
	
	//This returns back the milliseconds it took to perform the calculation
	public static long getRecTime(long index) {
		long startTime = System.nanoTime();
		fibRecursive(index);
		long endTime = System.nanoTime();
		
		return (endTime-startTime);
	}
	
	//This returns back the milliseconds it took to perform the calculation
	public static long getIterTime(long index) {
		long startTime = System.nanoTime();
		fibIterative(index);
		long endTime = System.nanoTime();
		
		return (endTime-startTime);
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
