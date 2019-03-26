package AdjacencyList;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph<T> {
    // Edgepair for key, boolean if they share a vertice
    private HashMap<Edge<T>, ArrayList<Edge<T>>> edges = new HashMap<>();

    public void addUniVertice(Edge<T> edgeA, Edge<T> edgeB){
        ArrayList<Edge<T>> tmpList = edges.get(edgeA);
        if (tmpList == null){
            tmpList = new ArrayList<>();
        }
        tmpList.add(edgeB);
        edges.put(edgeA, tmpList);
    }

    public void addBiVertice(Edge<T> edgeA, Edge<T> edgeB){
        addUniVertice(edgeA, edgeB);
        addUniVertice(edgeB, edgeA);
    }

    public boolean hasVertice(Edge<T> edgeA, Edge<T> edgeB) {
        ArrayList<Edge<T>> tmpList = edges.get(edgeA);
        if (tmpList == null){
            return false;
        }
        for (int i = 0; i < tmpList.size(); i++){
            if(tmpList.get(i).equals(edgeB)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[\n");
        for (Edge<T> edge: edges.keySet()) {
            strBuilder.append(edge.toString());
            ArrayList<Edge<T>> tmpList = edges.get(edge);
            for(Edge<T> e : tmpList){
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