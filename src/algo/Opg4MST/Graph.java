package algo.Opg4MST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Graph<T extends Comparable<T>> {
    // Hashmap with AirportCode key, Hashmap value.
    // Hashmap has adjacants airports as key, value is weight(distance).
    private HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

    public void addUniEdge(String airportCodeA, String airportCodeB, double weight){
        HashMap<String, Double> tmpHash = graph.get(airportCodeA);
        if (tmpHash == null){
            tmpHash = new HashMap<>();
        }
        tmpHash.put(airportCodeB, weight);
        graph.put(airportCodeA, tmpHash);
    }

    public void addBiEdge(String airportCodeA, String airportCodeB, double weight){
        addUniEdge(airportCodeA, airportCodeB, weight);
        addUniEdge(airportCodeB, airportCodeA, weight);
    }

    public boolean hasEdge(String airportCodeA, String airportCodeB) {
        HashMap<String, Double> tmpHash = graph.get(airportCodeA);
        if (tmpHash == null){
            return false;
        }
        return tmpHash.get(airportCodeB) != null;
    }

    public int getDegree(String vertex){
        return graph.get(vertex).size();
    }

    public ArrayList<String> getAdjacent(String airportCode){
        ArrayList<String> tmpArr = new ArrayList<>();
        HashMap<String, Double> map = graph.get(airportCode);
        if (map == null) {
            map = new HashMap<>();
            graph.put(airportCode, map);
        }
        tmpArr.addAll(map.keySet());
        return tmpArr;
    }

    public double getDistance(String airPortCodeA, String airportCodeB){
        HashMap<String, Double> afdelingA = graph.get(airPortCodeA);
        if (afdelingA == null){
            afdelingA = new HashMap<>();
            return Integer.MAX_VALUE;
        }
        if (afdelingA.get(airportCodeB) == null){
            return Integer.MAX_VALUE;
        }
        return afdelingA.get(airportCodeB);
    }

    public String getRandomKey(){
        Random rand = new Random();
        int n = rand.nextInt(graph.size());
        return (String) graph.keySet().toArray()[n];
    }

    public int getSize(){
        return graph.size();
    }

    public int getTotalEdges(){
        // Correct, since there are duplicate entries differenced by the airline companies, which we don't care about right now.
        int iterator = 0;
        for (String key : graph.keySet()) {
            iterator += graph.get(key).size();
        }
        return iterator;
    }
}
