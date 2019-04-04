package algo.Opg1DepthFirst;

import IO.RouteReader;
import models.Route;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Graph<String> graph = new Graph<String>();
        
        RouteReader routeReader = new RouteReader("src/dumps/depth.txt");
        //RouteReader routeReader = new RouteReader();

        for (Route r : routeReader.readRoutes()) {
            graph.addUniEdge(r.getSourceCode(), r.getDistinationCode());
        }

        String start = "ASF";
        String destination = "RTW";

        DepthFirst depth = new DepthFirst(graph, start, destination);
        ArrayList<String> path;
        try {
            path = depth.getShortestPath();
        } catch (NoPathException e) {
            System.err.println("Java.algo.DepthFirst.NoPathException: " + e.getMessage());
            return;
        }

        path.forEach((node) -> {
            System.out.println(node);
        });
    }

}
