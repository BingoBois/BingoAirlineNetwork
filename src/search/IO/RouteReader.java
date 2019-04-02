package search.IO;

import models.Airport;
import models.Route;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class RouteReader {
    private static final String FILENAME = "F:\\William\\Documents\\Dat2019\\Algoritmer\\BingoAirlineNetwork\\src\\dumps\\routes.txt";

    public HashMap<String, Route> readRoutes() {
        HashMap<String, Route> airlines = new HashMap<>();
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
                    airlines.put(split[0], new Route(
                            split[0],
                            split[1],
                            split[2],
                            Float.parseFloat(split[3]),
                            Float.parseFloat(split[4])
                    ));
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
