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
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

 
public class Main extends Application {

  @Override public void start(Stage primaryStage) throws Exception {

    TabPane tabPane = new TabPane();

    Tab tab1 = new Tab("LineChart");
    Tab tab2 = new Tab("BarChart");
    
    tabPane.getTabs().add(tab1);
    tabPane.getTabs().add(tab2);

    VBox vBox = new VBox(tabPane);
    Scene scene = new Scene(vBox, 1000, 1000);

    //Scene scene = new Scene(tabPane, 600, 600);
    
    //primaryStage.setScene(scene);
    primaryStage.setTitle("Valorant Ranks");
    primaryStage.setScene(new Scene(LineChartView.LineChart()));

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
