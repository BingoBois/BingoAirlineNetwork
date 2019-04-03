package graphs.AdjacencyList;

import graphs.IGraph;
import graphs.Vertex;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph<T extends Comparable<T>> implements IGraph<T> {
    private HashMap<Vertex<T>, ArrayList<Vertex<T>>> graph = new HashMap<>();

    public void addUniEdge(Vertex<T> vertexA, Vertex<T> vertexB){
        ArrayList<Vertex<T>> tmpList = graph.get(vertexA);
        if (tmpList == null){
            tmpList = new ArrayList<>();
        }
        tmpList.add(vertexB);
        graph.put(vertexA, tmpList);
    }

    public void addBiEdge(Vertex<T> vertexA, Vertex<T> vertexB){
        addUniEdge(vertexA, vertexB);
        addUniEdge(vertexB, vertexA);
    }

    @Override
    public void addWithNoEdge(Vertex<T> vertexA) {

    }

    public boolean hasEdge(Vertex<T> vertexA, Vertex<T> vertexB) {
        ArrayList<Vertex<T>> tmpList = graph.get(vertexA);
        if (tmpList == null){
            return false;
        }
        for (int i = 0; i < tmpList.size(); i++){
            if(tmpList.get(i).equals(vertexB)){
                return true;
            }
        }
        return false;
    }

    public int getDegree(Vertex<T> vertex){
        return graph.get(vertex).size();
    }

    public ArrayList<Vertex<T>> getAdjacent(Vertex<T> vertex){
        return graph.get(vertex);
    }

    @Override
    public String toString(){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[\n");
        for (Vertex<T> vertex : graph.keySet()) {
            strBuilder.append(vertex.toString());
            ArrayList<Vertex<T>> tmpList = graph.get(vertex);
            for(Vertex<T> e : tmpList){
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
