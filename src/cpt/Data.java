package cpt;

public class Data extends DataBase {

    private String valorantRank;
    private double distributionPercentage;
    private String monthAndYear;

    public Data(String rank, double percentage, String date){
        valorantRank = rank;
        distributionPercentage = percentage;
        monthAndYear = date;
    }

    public String toString(){
        return valorantRank + " " + distributionPercentage + " " + monthAndYear;
    }
    
}
