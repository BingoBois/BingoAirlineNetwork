package graphs;

import java.util.ArrayList;

public interface IGraph<T extends Comparable<T>> {
    public void addUniEdge(Vertex<T> vertexA, Vertex<T> vertexB);

    public void addBiEdge(Vertex<T> vertexA, Vertex<T> vertexB);

    public void addWithNoEdge(Vertex<T> vertexA);

    public boolean hasEdge(Vertex<T> vertexA, Vertex<T> vertexB);

    public int getDegree(Vertex<T> vertex);

    public ArrayList<Vertex<T>> getAdjacent(Vertex<T> vertex);
}
