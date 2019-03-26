package AdjacencyList;

public class Main {
    public static void main(String[] args) {
        Graph<String> adjacencyMatrix = new Graph();
        Edge e1 = new Edge<String>("har det godt");
        Edge e2 = new Edge<String>("giv op");
        Edge e3 = new Edge<String>("bing i 2019");
        Edge e4 = new Edge<String>("hvorfor");

        adjacencyMatrix.addUniVertice(e1, e2);
        adjacencyMatrix.addUniVertice(e1, e3);
        adjacencyMatrix.addUniVertice(e2, e3);
        adjacencyMatrix.addUniVertice(e3, e4);

        System.out.println(adjacencyMatrix.toString());
    }
}
