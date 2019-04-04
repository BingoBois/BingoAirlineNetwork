package algo.Opg2Dijkstra;

import IO.RouteReader;
import models.Route;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Graph<String> graph = new Graph<String>();
        RouteReader routeReader = new RouteReader();

        for (Route r : routeReader.readRoutes()) {
            graph.addUniEdge(r.getSourceCode(), r.getDistinationCode(), r.getDistance());
        }

        String start = "NIM";
        String destination = "DYU"; // DYU

        Dijkstra dijkstra = new Dijkstra(graph, start, destination);
        ArrayList<String> path;
        try {
            path = dijkstra.getShortestPath();
        } catch (NoPathException e) {
            System.err.println("Java.algo.Dijkstra.NoPathException: " + e.getMessage());
            return;
        }

        path.forEach((node) -> {
            System.out.println(node);
        });
    }

}
