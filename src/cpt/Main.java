package cpt;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class Main extends Application {

  @Override public void start(Stage primaryStage) throws Exception {

    //Creates a new tabPane
    TabPane tabPane = new TabPane();

    //Creats tabs
    Tab tab1 = new Tab("LineChart");
    Tab tab2 = new Tab("PieChart");
    
    //Add created tabs to tabPane
    tabPane.getTabs().add(tab1);
    tabPane.getTabs().add(tab2);

    //Remove ability to close the tabs
    tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

    //Create a vBox for each tab
    VBox vBox1 = new VBox();
    VBox vBox2 = new VBox();

    //Creats a checkbox
    CheckBox cb1 = new CheckBox("Remove Data From Front");
    vBox1.getChildren().addAll(cb1);

    //Adds chart to first vBox
    vBox1.getChildren().addAll(LineChartView.lineChart());
    tab1.setContent(vBox1);

    //Makes the checkbox cause removal of data
    EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e){
          if (cb1.isSelected()){
            LineChartView.getChart().getData().remove(0);
          }
      }
    };

    cb1.setOnAction(event1);
    
    //Pie chart added to second vBox
    vBox2.getChildren().addAll(PieChartView.pieChart());
    tab2.setContent(vBox2);

    //Set up the scene
    Scene scene = new Scene(tabPane, 1000, 1000);

    //Sets title of the stage
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
