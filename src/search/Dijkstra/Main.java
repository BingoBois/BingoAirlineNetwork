package search.Dijkstra;

import IO.RouteReader;
import models.Route;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Make graph & fill out data
        Graph adjacencyList = new Graph();
        RouteReader routeReader = new RouteReader();
        for (Route r : routeReader.readRoutes()) {
            adjacencyList.addUniEdge(r.getSourceCode(), r.getDistinationCode(), r.getDistance());
        }

        // Run the Dijkstra algorithm
        String start = "AER";
        //String destination = "KZN";
        //String destination = "OVB";
        String destination = "SGC";
        Dijkstra dijkstra = new Dijkstra(adjacencyList, start, destination);
        ArrayList<String> pathTaken = dijkstra.getShortestPath();
        for(String s : pathTaken){
            System.out.println(s);
        }
    }
}
