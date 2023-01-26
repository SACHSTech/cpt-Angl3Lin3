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
        
        PieChart.Data data[] = new PieChart.Data[25];

        for (int i = 0; i < 25; i++){
            data[i] = new PieChart.Data(DataBase.getValorantRanks().get(i), DataBase.getPercentageListData().get(i) + DataBase.getPercentageListData().get(i+25) + DataBase.getPercentageListData().get(i+50) + DataBase.getPercentageListData().get(i+75) + DataBase.getPercentageListData().get(i+100));
        }

        PieChart pie = new PieChart(FXCollections.observableArrayList(data));

        pie.setTitle("Valorant Rank Distribution Drill Down Pie Chart");

        for (int i = 0; i < 25; i++){
            setDrilldownData(pie, data[i], i);
        }

        

        return pie;
    }

    private static void setDrilldownData(final PieChart pie, final Data data,final int i) {
                                    
        PieChart.Data inside[] = new PieChart.Data[5];

        String[] monthsAndYears = {"November 2022", "October 2022", "September 2022", "August 2022", "July 2022"};
        int count = 0;
        for (int j = 0; j < 5; j++){
            inside[j] = new PieChart.Data(monthsAndYears[j], DataBase.getPercentageListData().get(count + i));
            count+=25;
        }
        
        data.getNode().setOnMouseClicked((MouseEvent t) -> {pie.setData(FXCollections.observableArrayList(inside));});
        

    }
    
}
