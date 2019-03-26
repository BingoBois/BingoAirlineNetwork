package ArrayOfEdges;

public class Main {
    public static void main(String[] args) {
        Graph<String> arrayOfEdges = new Graph();
        arrayOfEdges.addEdgePair(new Edge("sue jugurt"), new Edge("min bamse lugter"));
        Edge toGange = new Edge<String>("har det godt");
        arrayOfEdges.addEdgePair(new Edge("william"), toGange);
        arrayOfEdges.addEdgePair(new Edge("chris"), toGange);

        System.out.println(arrayOfEdges.toString());
    }
}
