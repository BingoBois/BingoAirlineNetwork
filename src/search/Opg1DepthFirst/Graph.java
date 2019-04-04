package search.Opg1DepthFirst;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph<T extends Comparable<T>> {
    // Hashmap with AirportCode key, Hashmap value.
    // Hashmap has adjacants airports as key, value is weight(distance).
    private HashMap<String, HashMap<String, Boolean>> graph = new HashMap<>();

    public void addUniEdge(String airportCodeA, String airportCodeB){
        HashMap<String, Boolean> tmpHash = graph.get(airportCodeA);
        if (tmpHash == null){
            tmpHash = new HashMap<>();
        }
        tmpHash.put(airportCodeB, true);
        graph.put(airportCodeA, tmpHash);
    }

    public void addBiEdge(String airportCodeA, String airportCodeB){
        addUniEdge(airportCodeA, airportCodeB);
        addUniEdge(airportCodeB, airportCodeA);
    }

    public boolean hasEdge(String airportCodeA, String airportCodeB) {
        HashMap<String, Boolean> tmpHash = graph.get(airportCodeA);
        if (tmpHash == null){
            return false;
        }
        return tmpHash.get(airportCodeB) != null;
    }

    public int getDegree(String vertex){
        return graph.get(vertex).size();
    }

    public ArrayList<String> getAdjacent(String airportCode) {
        ArrayList<String> tmpArr = new ArrayList<>();
        // System.out.println("123");
        HashMap<String, Boolean> map = graph.get(airportCode);
        // System.out.println("200");
        if (map == null) {
            map = new HashMap<>();
            graph.put(airportCode, map);
        }
        tmpArr.addAll(map.keySet());
        return tmpArr;
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
