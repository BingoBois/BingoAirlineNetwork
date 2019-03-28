package graphs.AdjacencyMap;

import graphs.IGraph;
import graphs.Vertex;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph<T> implements IGraph<T> {
    private HashMap<Vertex<T>, HashMap<Vertex<T>, Boolean>> graph = new HashMap<>();

    public void addUniEdge(Vertex<T> vertexA, Vertex<T> vertexB){
        HashMap<Vertex<T>, Boolean> tmpHash = graph.get(vertexA);
        if (tmpHash == null){
            tmpHash = new HashMap<>();
        }
        tmpHash.put(vertexB, true);
        graph.put(vertexA, tmpHash);
    }

    public void addBiEdge(Vertex<T> vertexA, Vertex<T> vertexB){
        addUniEdge(vertexA, vertexB);
        addUniEdge(vertexB, vertexA);
    }

    public boolean hasEdge(Vertex<T> vertexA, Vertex<T> vertexB) {
        HashMap<Vertex<T>, Boolean> tmpHash = graph.get(vertexA);
        if (tmpHash == null){
            return false;
        }
        return tmpHash.get(vertexB);
    }

    public int getDegree(Vertex<T> vertex){
        return graph.get(vertex).size();
    }

    public ArrayList<Vertex<T>> getAdjacent(Vertex<T> vertex){
        return (ArrayList<Vertex<T>>) graph.get(vertex).keySet();
    }

    @Override
    public String toString(){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[\n");
        for (Vertex<T> vertex : graph.keySet()) {
            strBuilder.append(vertex.toString());
            HashMap<Vertex<T>, Boolean> hm = graph.get(vertex);
            for(Vertex<T> e : hm.keySet()){
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