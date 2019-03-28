package graphs.ArrayOfEdges;

import graphs.IGraph;
import graphs.Vertex;

import java.util.ArrayList;

public class Graph<T> implements IGraph<T> {
    private ArrayList<Edge<T>> graph = new ArrayList<Edge<T>>();

    public void addUniEdge(Vertex<T> vertexA, Vertex<T> vertexB){
        graph.add(new Edge<T>(vertexA, vertexB));
    }

    public void addBiEdge(Vertex<T> vertexA, Vertex<T> vertexB){
        addUniEdge(vertexA, vertexB);
        addUniEdge(vertexB, vertexA);
    }

    @Override
    public boolean hasEdge(Vertex<T> vertexA, Vertex<T> vertexB) {
        for (Edge edge : graph) {
            if(edge.getVertexA().equals(vertexA) && edge.getVertexB().equals(vertexB)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Edge<T>> getGraph() {
        return graph;
    }

    public int getDegree(Vertex<T> vertex){
        return getAdjacent(vertex).size();
    }

    public ArrayList<Vertex<T>> getAdjacent(Vertex<T> vertex){
        ArrayList<Vertex<T>> adjacents = new ArrayList<Vertex<T>>();
        for (Edge edge : graph) {
            if(edge.getVertexA().equals(vertex)){
                adjacents.add(edge.getVertexB());
            }
        }
        return adjacents;
    }

    @Override
    public String toString(){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[\n");
        for (Edge ep : graph) {
            strBuilder.append(ep.toString());
            strBuilder.append("\n");
        }
        strBuilder.append("]\n");
        return strBuilder.toString();
    }
}
