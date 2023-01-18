package cpt;

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

public class Main extends Application {

  private LineChart chart;
  private CategoryAxis xAxis;
  private NumberAxis yAxis;

  public Parent createContent() {
    String[] monthsAndYears = {"July 2022", "August 2022", "September 2022", "October 2022", "Novemeber 2022"};
    xAxis = new CategoryAxis();
    xAxis.setCategories(FXCollections.<String>observableArrayList(monthsAndYears));
      yAxis = new NumberAxis("Percentage", 0, 10, 1);
      ObservableList<XYChart.Series> lineChartData =
          FXCollections.observableArrayList(
              new LineChart.Series<>("Iron 1",
                                     FXCollections.observableArrayList(
                  for (int i = 0; i < 5; i++){
                    new XYChart.Data<>(monthsAndYears[i], DataBase.getArrayListData());
                  }
                  new XYChart.Data<>(monthsAndYears[0], 1.0),
                  new XYChart.Data<>(monthsAndYears[1], 1.4),
                  new XYChart.Data<>(monthsAndYears[2], 1.9),
                  new XYChart.Data<>(monthsAndYears[3], 2.3),
                  new XYChart.Data<>(monthsAndYears[4], 0.5))),
              new LineChart.Series<>("Iron 2",
                                     FXCollections.observableArrayList(
                  new XYChart.Data<>(monthsAndYears[0], 1.6),
                  new XYChart.Data<>(monthsAndYears[1], 0.4),
                  new XYChart.Data<>(monthsAndYears[2], 2.9),
                  new XYChart.Data<>(monthsAndYears[3], 1.3),
                  new XYChart.Data<>(monthsAndYears[4], 0.9)))
          );
      chart = new LineChart(xAxis, yAxis, lineChartData);
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