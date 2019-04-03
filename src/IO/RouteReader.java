package IO;

import models.Route;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RouteReader {
    private static final String FILENAME = "src/dumps/routes.txt";

    public ArrayList<Route> readRoutes() {
        ArrayList<Route> airlines = new ArrayList<>();
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
                    airlines.add(new Route(
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
