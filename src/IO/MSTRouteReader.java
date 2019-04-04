package IO;

import algo.Opg4MST.Graph;
import models.Route;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MSTRouteReader {

    private String FILE_PATH = "src/dumps/routes.txt";

    private HashMap<String, Graph<String>> routes;

    private BufferedReader br;
    private FileReader fr;

    public MSTRouteReader() {
        routes = new HashMap<>();
    }

    public MSTRouteReader(String filePath) {
        this.FILE_PATH = filePath;
        routes = new HashMap<>();
    }

    public HashMap<String, Graph<String>> readRoutes() {
        try {
            fr = new FileReader(FILE_PATH);
            br = new BufferedReader(fr);
            String sCurrentLine = br.readLine();
            while ((sCurrentLine = br.readLine()) != null) {
                String[] split = sCurrentLine.split(";");
                Route route = new Route(split[0], split[1], split[2], Double.parseDouble(split[3]), Double.parseDouble(split[4]));
                if(routes.get(route.getAirlineCode()) == null){
                    routes.put(route.getAirlineCode(), new Graph<String>());
                }
                Graph g = routes.get(route.getAirlineCode());
                g.addUniEdge(route.getSourceCode(), route.getDistinationCode(), route.getDistance());
                routes.put(route.getAirlineCode(), g);
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
        return routes;
    }
    
}
