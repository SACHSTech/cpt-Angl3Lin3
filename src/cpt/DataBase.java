package cpt;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.*;

public class DataBase {

    private ArrayList<Data> data = new ArrayList<Data>();

    public static void main(String[] args) {
        
        try {
            BufferedReader scan = new BufferedReader(new FileReader("src/cpt/ValorantRanks.csv"));
        ArrayList<Data> data = new ArrayList<Data>();

        String line = null;
        int j = 0;

        while((line = scan.readLine()) != null){
            String[] str = line.split(",");

            if(j != 0) {
                for(int i = 0; i < str.length; i++) {
                    double percent = Double.parseDouble(str[1]);
                    Data input = new Data(str[0], percent, str[2]);
                    data.add(input);
                }
            }
            j++;
            
        }

        System.out.println(data);

        scan.close();

        } catch(Exception e) {
            
        }

    }

    public ArrayList<Data> getArrayListData(){
        return data;
    }
   

}
