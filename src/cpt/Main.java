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

 
public class Main extends Application {
  
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

      int valorantRank = 0;
      for (int j = 0; j < 25; j++){
          XYChart.Series<String, Number> series = new XYChart.Series<>();
          series.setName(DataBase.getValorantRanks().get(valorantRank));
          int count = 0 + j;
          for (int i = 0; i < 5; i++){
            series.getData().add(new XYChart.Data<String, Number>(CATEGORIES[i], DataBase.getPercentageListData().get(count)));
            count+=25;
          }
          chart.getData().add(series);
          valorantRank++;
      }
      
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
