package search.DepthFirst;

import graphs.Vertex;

public class DFSData<T> {
    private Vertex<T> vertex;
    private DFSData<T> parent;

    public DFSData(Vertex<T> vertex, DFSData<T> parent) {
        this.vertex = vertex;
        this.parent = parent;
    }

    public Vertex<T> getVertex() {
        return vertex;
    }

    public DFSData<T> getParent() {
        return parent;
    }
}
