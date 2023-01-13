package cpt;

public class Data {

    private String valorantRank;
    private double distributionPercentage;
    private String monthAndYear;

    public String getValorantRank(){
        return valorantRank;
    }

    public double getDistributionPercentage(){
        return distributionPercentage;
    }

    public String getMonthAndYear(){
        return monthAndYear;
    }

    public Data(String rank, double percentage, String date){
        valorantRank = rank;
        distributionPercentage = percentage;
        monthAndYear = date;
    }

    public String toString(){
        return valorantRank + " " + distributionPercentage + " " + monthAndYear;
    }
    
}
