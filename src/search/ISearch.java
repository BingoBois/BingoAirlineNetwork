package search;

import graphs.Vertex;

import java.util.ArrayList;

public interface ISearch<T extends Comparable<T>> {
    public ArrayList<Vertex<T>> search(Vertex<T> start, Vertex<T> end);
}
