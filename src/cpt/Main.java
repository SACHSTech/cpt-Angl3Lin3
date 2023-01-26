package cpt;

import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.Chart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

 
public class Main extends Application {

  @Override public void start(Stage primaryStage) throws Exception {

    TabPane tabPane = new TabPane();

    Tab tab1 = new Tab("LineChart");
    Tab tab2 = new Tab("PieChart");
    
    tabPane.getTabs().add(tab1);
    tabPane.getTabs().add(tab2);

    tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);


    VBox vBox1 = new VBox();
    VBox vBox2 = new VBox();
    //final VBox vbox1 = new VBox();

    CheckBox[] box = new CheckBox[25];

    for (int i = 0; i < 25; i++){
      CheckBox cb = new CheckBox(DataBase.getValorantRanks().get(i));
      box[i] = cb;
      //vBox.getChildren().addAll(cb);
      vBox1.getChildren().addAll(cb);
    }
    vBox1.getChildren().addAll(LineChartView.lineChart());
    tab1.setContent(vBox1);

    vBox2.getChildren().addAll(PieChartView.pieChart());
    tab2.setContent(vBox2);


    /** 
    for (int i = 0; i < 25; i++){
      if (box[i].isSelected()){
        chart.getData().remove(i);
      }
  }
  */

    Scene scene = new Scene(tabPane, 1000, 1000);

    primaryStage.setTitle("Valorant Ranks");
    primaryStage.setScene(scene);
    primaryStage.setFullScreen(true);

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
