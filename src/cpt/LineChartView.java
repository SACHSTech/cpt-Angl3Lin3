package cpt;

import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class LineChartView{
  
  //Instance Variables
  private static final String[] CATEGORIES = { "July 2022", "August 2022", "September 2022", "October 2022", "Novemeber 2022" };
  private static LineChart<String, Number> chart;
  private static LineChart<String, Number> series;
  private static CategoryAxis xAxis;
  private static NumberAxis yAxis;

  /**
   * Method that returns a line chart
   * 
   * @return chart
   */
  public static Parent lineChart() {

      //Creating the line chart
      xAxis = new CategoryAxis();
      yAxis = new NumberAxis();
      chart = new LineChart<>(xAxis, yAxis);
      //Setup chart
      chart.setTitle("Valorant Rank Distribution Line Graph");
      xAxis.setLabel("Month and Year");
      yAxis.setLabel("Percentage Distribution %");

      int valorantRank = 0;
      //For loop, creating each series
      for (int j = 0; j < 25; j++){
          XYChart.Series<String, Number> series = new XYChart.Series<>();
          series.setName(DataBase.getValorantRanks().get(valorantRank));
          int count = 0 + j;
          //For loop, adding the data to each series
          for (int i = 0; i < 5; i++){
            series.getData().add(new XYChart.Data<String, Number>(CATEGORIES[i], DataBase.getPercentageListData().get(count)));
            count+=25;
          }
          //Adds the series to the chart
          chart.getData().add(series);
          valorantRank++;
      }

      //Returns the chart
      return chart;
    }

    /**
     * Method the gets the Chart
     * 
     * @return chart, as a LineChart<String, Number>
     */
    public static LineChart<String, Number> getChart(){
      return chart;
    }

    /**
     * Methods that gets the Series
     * 
     * @return series, as a LineChart<String, Number>
     */
    public static LineChart<String,Number> getSeries(){
      return series;
    }

}