package search.Opg1DepthFirst;

import java.util.*;

public class DepthFirst {

    private Stack<HeapType> unvisitedEdges;
    private HashMap<String, Boolean> visited;
    private String start, destination;
    private Graph<String> graph;
    
    public DepthFirst(Graph<String> graph, String start, String destination) {
        this.unvisitedEdges = new Stack<HeapType>();
        this.visited = new HashMap<>();
        this.start = start;
        this.destination = destination;
        this.graph = graph;
    }

    public ArrayList<String> getShortestPath() throws NoPathException {
        ArrayList<String> pathTaken = new ArrayList<>();
        // System.out.println("There are initially: " + graph.getAdjacent(start).size() + " adjacent nodes");
        HeapType startHeapType = new HeapType(start, 0, null);
        // Start iterator at endHeapType
        HeapType iterator = depthSearch(startHeapType);
        while (iterator.getParent() != null){
            pathTaken.add(iterator.getAirCode());
            iterator = iterator.getParent();
        }
        pathTaken.add(startHeapType.getAirCode());
        Collections.reverse(pathTaken);
        return pathTaken;
    }

    
    private HeapType depthSearch(HeapType current) throws NoPathException {
        if(current.getAirCode().equals(destination)) {
            return current;
        }
        visited.put(current.getAirCode(), true);
        ArrayList<String> adjacent = graph.getAdjacent(current.getAirCode());
        for (String adj : adjacent) {
            if((visited.get(adj) == null || visited.get(adj) == false) && !unvisitedContains(adj)) {
                unvisitedEdges.add(new HeapType(adj, current.getJumps() + 1, current));
            }
        }
        if (unvisitedEdges.size() <= 0) {
            throw new NoPathException("No unvisited nodes left");
        }
        HeapType next = unvisitedEdges.pop();
        return depthSearch(next);
    }


    public boolean unvisitedContains(String airportCode) {
        for (HeapType heapObject : unvisitedEdges) {
            if (heapObject.getAirCode().equals(airportCode)) {
                return true;
            }
        }
        return false;
    }

}
