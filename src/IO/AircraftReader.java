package IO;

import models.Aircraft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class AircraftReader {
    private static final String FILENAME = "F:\\William\\Documents\\Dat2019\\Algoritmer\\BingoAirlineNetwork\\src\\dumps\\aircraft.txt";

    public HashMap<String, Aircraft> readAircrafts() {
        HashMap<String, Aircraft> airlines = new HashMap<>();
        BufferedReader br = null;
        FileReader fr = null;

        try {
            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;
            boolean isFirst = true;
            while ((sCurrentLine = br.readLine()) != null) {
                if(isFirst){
                    isFirst = false;
                }else{

                    String[] split = sCurrentLine.split(";");
                    if(split.length == 3)
                        airlines.put(split[0], new Aircraft(split[0], split[1], split[2]));
                }
            }
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
        return airlines;
    }
}
