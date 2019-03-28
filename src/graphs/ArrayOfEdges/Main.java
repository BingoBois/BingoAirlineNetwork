package graphs.ArrayOfEdges;

import graphs.Vertex;

public class Main {
    public static void main(String[] args) {
        Graph<String> graph = new Graph();
        Vertex e1 = new Vertex<String>("har det godt");
        Vertex e2 = new Vertex<String>("giv op");
        Vertex e3 = new Vertex<String>("bing i 2019");
        Vertex e4 = new Vertex<String>("hvorfor");
        graph.addUniEdge(e1, e2);
        graph.addUniEdge(e1, e3);
        graph.addUniEdge(e2, e3);
        graph.addUniEdge(e3, e4);

        System.out.println(graph.toString());
    }
}
