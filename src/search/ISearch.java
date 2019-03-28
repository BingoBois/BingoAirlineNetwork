package search;

import graphs.Vertex;

import java.util.ArrayList;

public interface ISearch<T> {
    public ArrayList<Vertex<T>> search(Vertex<T> start, Vertex<T> end);
}
