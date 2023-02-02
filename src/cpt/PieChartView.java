package cpt;

import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.input.MouseEvent;

public class PieChartView {

    //Instance variables
    private static PieChart data;

    /**
     * Method that makes the pie chart
     * 
     * @return pie, the pie chart
     */
    public static Parent pieChart() {
        
        //Creating the Array for each part of the Pie chart data
        PieChart.Data data[] = new PieChart.Data[25];

        //Loop that adds the data of each piece of the pie chart
        for (int i = 0; i < 25; i++){
            data[i] = new PieChart.Data(DataBase.getValorantRanks().get(i), DataBase.getPercentageListData().get(i) + DataBase.getPercentageListData().get(i+25) + DataBase.getPercentageListData().get(i+50) + DataBase.getPercentageListData().get(i+75) + DataBase.getPercentageListData().get(i+100));
        }

        //Adds the data to the pie chart
        PieChart pie = new PieChart(FXCollections.observableArrayList(data));

        //Sets the charts title
        pie.setTitle("Valorant Rank Distribution Drill Down Pie Chart");

        //For loop calling the setDrilldownData method to get the drill down parts of the chart
        for (int i = 0; i < 25; i++){
            setDrilldownData(pie, data[i], i);
        }

        //Returns the chart
        return pie;
    }

    /**
     * Method that creates the drill down data of each data piece
     * 
     * @param pie chart
     * @param data data in the chart 
     * @param i how many pieces are in the chart
     */
    private static void setDrilldownData(final PieChart pie, final Data data,final int i) {
        
        //Creates how many drill down pieces there are
        PieChart.Data inside[] = new PieChart.Data[5];

        //Adds each section of the chart
        String[] monthsAndYears = {"November 2022", "October 2022", "September 2022", "August 2022", "July 2022"};
        int count = 0;

        //Adds the data to each section of the chart
        for (int j = 0; j < 5; j++){
            inside[j] = new PieChart.Data(monthsAndYears[j], DataBase.getPercentageListData().get(count + i));
            count+=25;
        }
        
        //Gets the drill down when each section is clicked
        data.getNode().setOnMouseClicked((MouseEvent t) -> {pie.setData(FXCollections.observableArrayList(inside));});

    }

    /**
     * Method that returns the data of the pie chart
     * 
     * @return data as a PieChart
     */
    public static PieChart getPieChart(){
        return data;
    }
    
}
