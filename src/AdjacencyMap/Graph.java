package AdjacencyMap;

import java.util.HashMap;

public class Graph<T> {
    // Edgepair for key, boolean if they share a vertice
    private HashMap<Edge<T>, HashMap<Edge<T>, Boolean>> edges = new HashMap<>();

    public void addUniVertice(Edge<T> edgeA, Edge<T> edgeB){
        HashMap<Edge<T>, Boolean> tmpHash = edges.get(edgeA);
        if (tmpHash == null){
            tmpHash = new HashMap<>();
        }
        tmpHash.put(edgeB, true);
        edges.put(edgeA, tmpHash);
    }

    public void addBiVertice(Edge<T> edgeA, Edge<T> edgeB){
        addUniVertice(edgeA, edgeB);
        addUniVertice(edgeB, edgeA);
    }

    public boolean hasVertice(Edge<T> edgeA, Edge<T> edgeB) {
        HashMap<Edge<T>, Boolean> tmpHash = edges.get(edgeA);
        if (tmpHash == null){
            return false;
        }
        return tmpHash.get(edgeB);
    }

    @Override
    public String toString(){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[\n");
        for (Edge<T> edge: edges.keySet()) {
            strBuilder.append(edge.toString());
            HashMap<Edge<T>, Boolean> hm = edges.get(edge);
            for(Edge<T> e : hm.keySet()){
                strBuilder.append(" { ");
                strBuilder.append(e.toString());
                strBuilder.append(" },");
            }
            strBuilder.append("\n");
        }
        strBuilder.append("]\n");
        return strBuilder.toString();
    }
}