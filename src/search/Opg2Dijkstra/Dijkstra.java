package search.Opg2Dijkstra;

import java.util.*;

public class Dijkstra {

    static class minHeapComparator implements Comparator<HeapType> {
        @Override
        public int compare(HeapType x, HeapType y) {
            return (int)(x.getDistance() - y.getDistance());
        }
    }

    private PriorityQueue<HeapType> unvisitedEdges;
    private HashMap<String, Boolean> visited;
    private String start, destination;
    private Graph<String> graph;

    public Dijkstra(Graph<String> graph, String start, String destination) {
        this.unvisitedEdges = new PriorityQueue<HeapType>(graph.getTotalEdges(), new minHeapComparator());
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
        HeapType iterator = dijkstraSearch(startHeapType);
        while (iterator.getParent() != null){
            pathTaken.add(iterator.getAirCode());
            iterator = iterator.getParent();
        }
        pathTaken.add(startHeapType.getAirCode());
        Collections.reverse(pathTaken);
        return pathTaken;
    }

    private HeapType dijkstraSearch(HeapType current) throws NoPathException {
        // 1. Am i done?
        if (current.getAirCode().equals(this.destination)){
            return current;
        }

        // 2. Add current to visited
        visited.put(current.getAirCode(), true);

        // 3. Add new unvisited adjacent edges to unvisited
        ArrayList<String> tmpArr = graph.getAdjacent(current.getAirCode());
        for (String s : tmpArr) {
            if ((visited.get(s) == null || visited.get(s) == false) && !unvisitedContains(s)) {
                double distance = current.getDistance() + graph.getDistance(s, current.getAirCode());
                unvisitedEdges.add(new HeapType(s, distance, current));
            }
        }
        
        // 4. Go to the first element in unvisitedEdges that hasn't been visited yet.
        if (unvisitedEdges.isEmpty()){
            throw new NoPathException("No Path exists between \"" + start + "\" and \"" + destination + "\"");
        }
        HeapType selectedUnvisited = unvisitedEdges.poll();
        // System.out.println("Attempting to use Node: " + selectedUnvisited.getAirCode() + " (PARENT: " + selectedUnvisited.getParent().getAirCode() + ") to get from " + start + " to " + destination);
        return dijkstraSearch(selectedUnvisited);
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
