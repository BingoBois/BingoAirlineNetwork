package search.DepthFirst;

import graphs.ArrayOfEdges.Graph;
import graphs.Vertex;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Graph<String> graph = new Graph();
        Vertex e1 = new Vertex<String>("1");
        Vertex e2 = new Vertex<String>("2");
        Vertex e3 = new Vertex<String>("3");
        Vertex e4 = new Vertex<String>("4");
        Vertex e5 = new Vertex<String>("5");
        Vertex e6 = new Vertex<String>("6");
        Vertex e7 = new Vertex<String>("7");
        Vertex e8 = new Vertex<String>("8");
        Vertex e9 = new Vertex<String>("9");


        //Shows worst case scenario of depth first
        //graph.addUniEdge(e1, e2);

        graph.addUniEdge(e1, e3);
        graph.addUniEdge(e3, e4);
        graph.addUniEdge(e4, e5);
        graph.addUniEdge(e5, e6);
        graph.addUniEdge(e6, e7);
        graph.addUniEdge(e7, e8);
        //graph.addUniEdge(e8, e9);
        //graph.addUniEdge(e9, e2);

        DFSSearch dfsSearch = new DFSSearch(graph);
        ArrayList<Vertex<String>> path = dfsSearch.search(e1, e2);
        System.out.println(path.toString());
    }
}
