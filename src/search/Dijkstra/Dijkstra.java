package search.Dijkstra;

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
    private Graph graph;

    public Dijkstra(Graph graph, String start, String destination) {
        this.unvisitedEdges = new PriorityQueue(graph.getTotalEdges(), new minHeapComparator());
        this.visited = new HashMap<>();
        this.start = start;
        this.destination = destination;
        this.graph = graph;
    }

    public ArrayList<String> getShortestPath(){
        ArrayList<String> pathTaken = new ArrayList<>();
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

    private HeapType dijkstraSearch(HeapType current){
        // 1. Am i done?
        if (current.getAirCode().equals(this.destination)){
            return current;
        }
        // 2. Add new unvisited adjacent edges to unvisited
        ArrayList<String> tmpArr = graph.getAdjacent(current.getAirCode());
        for (String s : tmpArr){
            if(visited.get(s) == null){
                double distance = current.getDistance() + graph.getDistance(s, current.getAirCode());
                unvisitedEdges.add(new HeapType(s, distance, current));
            }
        }
        // 3. Add current to visited
        visited.put(current.getAirCode(), true);
        // 4. Go to the first element in unvisitedEdges that hasn't been visited yet.
        if (unvisitedEdges.isEmpty()){
            throw new Error("No Path exists");
        }
        return dijkstraSearch(unvisitedEdges.poll());
    }
}
