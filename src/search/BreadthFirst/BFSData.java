package search.BreadthFirst;

import graphs.Vertex;

public class BFSData<T extends Comparable<T>> {
    private BFSData<T> parent;
    private Vertex<T> vertex;

    public BFSData(Vertex<T> vertex, BFSData<T> parent){
        this.parent = parent;
        this.vertex = vertex;
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

}
