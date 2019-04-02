package search.Dijkstra;

import graphs.Vertex;

public class DKData<T extends Comparable<T>> implements Comparable<DKData<T>> {
    private DKData<T> parent;
    private Vertex<T> vertex;

    public DKData(Vertex<T> vertex, DKData<T> parent){
        this.parent = parent;
        this.vertex = vertex;
    }

    public DKData<T> getParent() {
        return parent;
    }

    public void setParent(DKData<T> parent) {
        this.parent = parent;
    }

    public Vertex<T> getVertex() {
        return vertex;
    }

    public void setCurrent(Vertex<T> current) {
        this.vertex = current;
    }

    @Override
    public int compareTo(DKData<T> o) {
        return vertex.compareTo(o.getVertex());
    }
}