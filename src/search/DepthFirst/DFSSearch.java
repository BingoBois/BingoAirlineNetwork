package search.DepthFirst;

import graphs.IGraph;
import graphs.Vertex;
import search.ISearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class DFSSearch<T> implements ISearch<T> {
    private IGraph graph;
    private Stack<DFSData> unvisited;
    private HashMap<Vertex, Boolean> visited;

    public DFSSearch(IGraph graph) {
        this.graph = graph;
        this.unvisited = new Stack<>();
        this.visited = new HashMap<>();
    }

    private DFSData<T> searchDeep(DFSData<T> current, Vertex<T> end){
        if(current.getVertex().equals(end)){
            return current;
        }
        ArrayList<Vertex<T>> adjacent = graph.getAdjacent(current.getVertex());
        for (Vertex<T> adj : adjacent) {
            if(!hasBeenVisited(adj)){
                unvisited.push(new DFSData(adj, current));
            }
        }
        visited.put(current.getVertex(), true);
        return searchDeep(unvisited.pop(), end);
    }

    public ArrayList<Vertex<T>> search(Vertex<T> start, Vertex<T> end){
        ArrayList<Vertex<T>> path = new ArrayList<>();
        DFSData<T> dfsIterator = searchDeep(new DFSData<T>(start, null), end);
        while(dfsIterator.getParent() != null){
            path.add(dfsIterator.getVertex());
            dfsIterator = dfsIterator.getParent();
        }
        path.add(dfsIterator.getVertex());
        Collections.reverse(path);
        return path;
    }

    private boolean hasBeenVisited(Vertex<T> vertex){
        return (visited.get(vertex) == null ? false : true);
    }
}
