package ArrayOfEdges;

import java.util.ArrayList;

public class Graph<T> {
    private ArrayList<EdgePair<T>> edges = new ArrayList<EdgePair<T>>();

    public void addEdgePair(Edge<T> edgeA, Edge<T> edgeB){
        edges.add(new EdgePair<T>(edgeA, edgeB));
    }

    public ArrayList<EdgePair<T>> getEdges() {
        return edges;
    }

    @Override
    public String toString(){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[\n");
        for (EdgePair ep : edges) {
            strBuilder.append(ep.toString());
            strBuilder.append("\n");
        }
        strBuilder.append("]\n");
        return strBuilder.toString();
    }
}
