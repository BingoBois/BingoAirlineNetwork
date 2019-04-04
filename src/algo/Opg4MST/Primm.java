package algo.Opg4MST;

import algo.Opg3Dijkstra.Dijkstra;
import algo.Opg3Dijkstra.HeapType;

import java.util.*;

public class Primm {

    static class minHeapComparator implements Comparator<MSTData> {
        @Override
        public int compare(MSTData x, MSTData y) {
            return (int)(x.getWeight() - y.getWeight());
        }
    }

    HashMap<String, Boolean> visited;
    PriorityQueue<MSTData> unvisited;
    Graph<String> graph;

    public Primm(Graph<String> graph) {
        this.unvisited = new PriorityQueue<MSTData>(graph.getTotalEdges(), new minHeapComparator());
        this.visited = new HashMap<>();
        this.graph = graph;
    }

    public Graph getMST(){
        String iterator = this.graph.getRandomKey();
        Graph mst = new Graph();
        do{
            visited.put(iterator, true);
            addAllAdjencies(iterator);
            MSTData next = unvisited.poll();
            if(next == null){
                break;
            }
            mst.addUniEdge(iterator, next.destination, next.weight);
            iterator = unvisited.poll().destination;
        }while(unvisited.size() > 0);
        return mst;
    }

    public void addAllAdjencies(String key){
        ArrayList<String> temp = this.graph.getAdjacent(key);
        for(String s : temp){
            for(MSTData mst : unvisited){
                if(!s.equals(mst.destination) && !s.equals(mst.source) && visited.get(s) == null ){
                    unvisited.add(new MSTData(key,s, graph.getDistance(key, s)));
                }
            }
        }
    }
}
