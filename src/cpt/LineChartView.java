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
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

 
public class LineChartView{
  
  private static final String[] CATEGORIES = { "July 2022", "August 2022", "September 2022", "October 2022", "Novemeber 2022" };
  private static LineChart<String, Number> chart;
  private static CategoryAxis xAxis;
  private static NumberAxis yAxis;

  public static Parent lineChart() {

      xAxis = new CategoryAxis();
      yAxis = new NumberAxis();
      chart = new LineChart<>(xAxis, yAxis);
      // setup chart
      chart.setTitle("Valorant Rank Distribution Line Graph");
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

    public static LineChart<String, Number> getChart(){
      return chart;
    }

    public static NumberAxis getYAxis(){
      return yAxis;
    }
}