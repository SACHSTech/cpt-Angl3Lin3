package cpt;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.*;

public class DataBase {

    private static ArrayList<Data> data = new ArrayList<Data>();
    private static ArrayList<Double> percentageData = new ArrayList<Double>();

    public static void main(String[] args) {
        
        try {
            BufferedReader scan = new BufferedReader(new FileReader("src/cpt/ValorantRanks.csv"));
        ArrayList<Data> data = new ArrayList<Data>();

        String line = null;
        int j = 0;

        while((line = scan.readLine()) != null){
            String[] str = line.split(",");

            if(j != 0) {
                double percent = Double.parseDouble(str[1]);
                Data input = new Data(str[0], percent, str[2]);
                data.add(input);
                percentageData.add(percent);
                
            }
            j++;
            
        }

        System.out.println(data);

        scan.close();

        } catch(Exception e) {
            
        }

    }

    public static ArrayList<Data> getArrayListData(){
        return data;
    }
   
    public static ArrayList<Double> getPercentageListData(){
        return percentageData;
    }

}
