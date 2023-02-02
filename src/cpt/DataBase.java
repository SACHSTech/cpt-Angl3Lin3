package cpt;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.*;

public class DataBase {

    //Instance variables
    private static ArrayList<Data> data = new ArrayList<Data>();
    private static ArrayList<Double> percentageData = new ArrayList<Double>();
    private static ArrayList<String> ranksData = new ArrayList<String>();

    public static void run() {
        
        try {
        //Reads the ValorantRanks.csv file
        BufferedReader scan = new BufferedReader(new FileReader("src/cpt/ValorantRanks.csv"));
        //Creates an ArrayList
        ArrayList<Data> data = new ArrayList<Data>();

        String line = null;
        int j = 0;

        //While loop to read everything in the file until there is nothing
        while((line = scan.readLine()) != null){
            //Divide the string by commas
            String[] str = line.split(",");

            //Removes the first row headers
            if(j != 0) {
                //Puts all the data in the Data.java constructor
                double percent = Double.parseDouble(str[1]);
                Data input = new Data(str[0], percent, str[2]);
                //Add values to ArrayLists
                data.add(input);
                percentageData.add(percent);
                ranksData.add(str[0]);
                
            }
            j++;
            
        }

        scan.close();

        } catch(Exception e) {
            
        }

    }

    /**
     * Method that gets data
     * 
     * @return data as an ArrayList<Data>
     */
    public static ArrayList<Data> getArrayListData(){
        return data;
    }
   
    /**
     * Method that gets percentageData
     * 
     * @return percentageData as an ArrayList<Double>
     */
    public static ArrayList<Double> getPercentageListData(){
        run();
        return percentageData;
    }
    
    /**
     * Method that gets ranksData
     * 
     * @return ranksData as an ArrayList<String>
     */
    public static ArrayList<String> getValorantRanks(){
        run();
        return ranksData;
    }


}
