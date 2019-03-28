package graphs.AdjacencyMap;

import graphs.Vertex;

public class Main {
    public static void main(String[] args) {
        Graph<String> adjacencyMatrix = new Graph();
        Vertex e1 = new Vertex<String>("har det godt");
        Vertex e2 = new Vertex<String>("giv op");
        Vertex e3 = new Vertex<String>("bing i 2019");
        Vertex e4 = new Vertex<String>("hvorfor");

        adjacencyMatrix.addUniEdge(e1, e2);
        adjacencyMatrix.addUniEdge(e1, e3);
        adjacencyMatrix.addUniEdge(e2, e3);
        adjacencyMatrix.addUniEdge(e3, e4);

        System.out.println(adjacencyMatrix.toString());
    }
}
