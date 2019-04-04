package algo.Opg1BreadthFirst;

import IO.RouteReader;
import models.Route;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Graph<String> graph = new Graph<String>();
        RouteReader routeReader = new RouteReader();

        for (Route r : routeReader.readRoutes()) {
            graph.addUniEdge(r.getSourceCode(), r.getDistinationCode(), r.getTime());
        }

        String start = "ASF";
        String destination = "RTW"; // DYU

        BreadthFirst breadth = new BreadthFirst(graph, start, destination);
        ArrayList<String> path;
        try {
            path = breadth.getShortestPath();
        } catch (NoPathException e) {
            System.err.println("Java.algo.BreadthFirst.NoPathException: " + e.getMessage());
            return;
        }

        path.forEach((node) -> {
            System.out.println(node);
        });
    }

}
