package search.BreadthFirst;

import graphs.ArrayOfEdges.Graph;
import graphs.Vertex;
import search.DepthFirst.DFSSearch;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Graph<String> graph = new Graph();
        Vertex e1 = new Vertex<String>("1");
        Vertex e2 = new Vertex<String>("2");
        Vertex e3 = new Vertex<String>("3");
        Vertex e4 = new Vertex<String>("4");

        //Shows worst case scenario of depth first
        graph.addBiEdge(e1, e2);
        graph.addBiEdge(e1, e3);
        graph.addBiEdge(e2, e3);
        graph.addBiEdge(e3, e4);

        BFSSearch bf = new BFSSearch(graph);
        ArrayList<Vertex<String>> path = bf.search(e1, e4);
        System.out.println(path.toString());
    }
}
