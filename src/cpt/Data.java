package cpt;

public class Data {

    //Instance Variables
    private String valorantRank;
    private double distributionPercentage;
    private String monthAndYear;

    /**
     * Method that gets the valorantRank variable 
     * 
     * @return String of valorantRank variable
     */
    public String getValorantRank(){
        return valorantRank;
    }

    /**
     * Method that gets the distributionPercentage variable
     * 
     * @return double of the distributionPercentage variable
     */
    public double getDistributionPercentage(){
        return distributionPercentage;
    }

    /**
     * Method that gets the monthAndYear variable
     * 
     * @return String of the monthAndYear variable
     */
    public String getMonthAndYear(){
        return monthAndYear;
    }

    /**
     * Contructor that asks for rank, percentage, and date
     * 
     * @param rank in String of the csv file, rank category
     * @param percentage in double of the csv file, percent of people in a given rank
     * @param date in String of the csv file, when this data was taken
     */
    public Data(String rank, double percentage, String date){
        valorantRank = rank;
        distributionPercentage = percentage;
        monthAndYear = date;
    }

    /**
     * Method that gives the toString of all three variables
     * 
     */
    public String toString(){
        return valorantRank + " " + distributionPercentage + " " + monthAndYear;
    }
    
}
