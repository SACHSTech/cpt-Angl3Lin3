package cpt;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class PieChartView {

    public static Parent pieChart() {
        
        Data A, B, C, D;
        /**
        data = FXCollections.observableArrayList(A = new Data("A", 20),
                                                 B = new Data("B", 30),
                                                 C = new Data("C", 10),
                                                 D = new Data("D", 40));
        final PieChart pie = new PieChart(data);
        */
        PieChart.Data data[] = new PieChart.Data[25];

        for (int i = 0; i < 25; i++){
            data[i] = new PieChart.Data(DataBase.getValorantRanks().get(i), DataBase.getPercentageListData().get(i) + DataBase.getPercentageListData().get(i+25) + DataBase.getPercentageListData().get(i+50) + DataBase.getPercentageListData().get(i+75) + DataBase.getPercentageListData().get(i+100));
        }

        PieChart pie = new PieChart(FXCollections.observableArrayList(data));
        //final String drillDownChartCss =
        //   getClass().getResource("DrilldownChart.css").toExternalForm();
        //pie.getStylesheets().add(drillDownChartCss);

        for (int i = 0; i< 25; i++){
            setDrilldownData(pie, data[i], i);
        }

        return pie;
    }

    private static void setDrilldownData(final PieChart pie, final Data data,
                                  final int i) {
        data.getNode().setOnMouseClicked((MouseEvent t) -> {
            pie.setData(FXCollections.observableArrayList(
                    new Data(i + "-1", 7),
                    new Data(i + "-2", 2),
                    new Data(i + "-3", 5),
                    new Data(i + "-4", 3),
                    new Data(i + "-5", 2)));
        });
    }
    
}
