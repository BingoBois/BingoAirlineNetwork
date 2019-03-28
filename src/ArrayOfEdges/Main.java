package ArrayOfEdges;

public class Main {
    public static void main(String[] args) {
        Graph<String> graph = new Graph();
        graph.addBiEdge(new Vertex("sue jugurt"), new Vertex("min bamse lugter"));
        Vertex toGange = new Vertex<String>("har det godt");
        graph.addBiEdge(new Vertex("william"), toGange);
        graph.addBiEdge(new Vertex("chris"), toGange);

        System.out.println(graph.toString());
    }
}
