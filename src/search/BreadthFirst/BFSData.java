package search.BreadthFirst;

import graphs.Vertex;

public class BFSData<T> {
    private BFSData<T> parent;
    private Vertex<T> vertex;
    private int distance;

    public BFSData(Vertex<T> vertex, BFSData<T> parent, int distance){
        this.parent = parent;
        this.vertex = vertex;
        this.distance = distance;
    }

    public BFSData<T> getParent() {
        return parent;
    }

    public void setParent(BFSData<T> parent) {
        this.parent = parent;
    }

    public Vertex<T> getVertex() {
        return vertex;
    }

    public void setCurrent(Vertex<T> current) {
        this.vertex = current;
    }

    public int getDistance() {
        return distance;
    }
}
