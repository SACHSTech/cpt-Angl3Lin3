package cpt;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

 
public class LineChartView extends Application {
  
  private static final String[] CATEGORIES = { "July 2022", "August 2022", "September 2022", "October 2022", "Novemeber 2022" };
  private LineChart<String, Number> chart;
  private CategoryAxis xAxis;
  private NumberAxis yAxis;

  public Parent createContent() {

      xAxis = new CategoryAxis();
      yAxis = new NumberAxis();
      chart = new LineChart<>(xAxis, yAxis);
      // setup chart
      chart.setTitle("Valorant Rank Distribution");
      xAxis.setLabel("Month and Year");
      yAxis.setLabel("Percentage Distribution %");
      // add starting data

      XYChart.Series<String, Number> series1 = new XYChart.Series<>();
      series1.setName("Iron 1");
      int count = 0;
      for (int i = 0; i < 5; i++){
        series1.getData().add(new XYChart.Data<String, Number>(CATEGORIES[i], DataBase.getPercentageListData().get(count)));
        count+=25;
      }
      chart.getData().add(series1);

      XYChart.Series<String, Number> series2 = new XYChart.Series<>();
      series2.setName("Iron 2");
      count = 1;
      for (int i = 0; i < 5; i++){
        series2.getData().add(new XYChart.Data<String, Number>(CATEGORIES[i], DataBase.getPercentageListData().get(count)));
        count+=25;
      }
      chart.getData().add(series2);

      XYChart.Series<String, Number> series3 = new XYChart.Series<>();
      series3.setName("Iron 3");
      count = 2;
      for (int i = 0; i < 5; i++){
        series3.getData().add(new XYChart.Data<String, Number>(CATEGORIES[i], DataBase.getPercentageListData().get(count)));
        count+=25;
      }
      chart.getData().add(series3);

      XYChart.Series<String, Number> series4 = new XYChart.Series<>();
      series4.setName("Bronze 1");
      count = 3;
      for (int i = 0; i < 5; i++){
        series4.getData().add(new XYChart.Data<String, Number>(CATEGORIES[i], DataBase.getPercentageListData().get(count)));
        count+=25;
      }
      chart.getData().add(series4);

      return chart;
  }

  @Override public void start(Stage primaryStage) throws Exception {
      primaryStage.setScene(new Scene(createContent()));
      primaryStage.show();
  }

  /**
   * Java main for when running without JavaFX launcher
   * @param args command line arguments
   */
  public static void main(String[] args) {
      launch(args);
  }
  
}
