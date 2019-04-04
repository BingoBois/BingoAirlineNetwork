package IO;

import models.Route;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RouteReader {

    private String FILE_PATH = "src/dumps/routes.txt";

    private ArrayList<Route> airlines;

    private BufferedReader br;
    private FileReader fr;

    public RouteReader() {
        airlines = new ArrayList<>();
    }

    public RouteReader(String filePath) {
        this.FILE_PATH = filePath;
        airlines = new ArrayList<>();
    }

    public ArrayList<Route> readRoutes() {
        try {
            fr = new FileReader(FILE_PATH);
            br = new BufferedReader(fr);
            String sCurrentLine = br.readLine();
            while ((sCurrentLine = br.readLine()) != null) {
                String[] split = sCurrentLine.split(";");
                airlines.add(new Route(
                    split[0],
                    split[1],
                    split[2],
                    Float.parseFloat(split[3]),
                    Float.parseFloat(split[4])
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return airlines;
    }
    
}
