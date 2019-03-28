package search.BreadthFirst;

import graphs.IGraph;
import graphs.Vertex;
import search.ISearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class BFSSearch<T> implements ISearch<T> {
    private LinkedList<BFSData<T>> unvisited = new LinkedList<>();
    private HashMap<Vertex<T>, Boolean> visited = new HashMap<>();
    private IGraph graph;
     /*
        er vi på end - Så er vi i mål - Ellers hopper vi videre til næste trin
        Hvert verteces består af forbundende verteces som den ikke har besøgt endnu
        Liste af verteces - Sorteret efter distance - For hvert iteration går vi videre til næste lag
        Tag første element i listen
     */
    public BFSSearch(IGraph<T> graph){
      this.graph = graph;
    }

    public BFSData<T> searchDeep(BFSData<T> current, Vertex<T> end){
        if(current.getVertex().equals(end)){
            return current;
        }

        ArrayList<Vertex<T>> adjacent = graph.getAdjacent(current.getVertex());

        for(Vertex<T> data : adjacent){
            if(!hasVisited(data) && !hasUnvisited(data))
                System.out.println("Adding vertex to unvisited " + data.toString());
                unvisited.add(new BFSData<>(data, current, current.getDistance()));
        }

        if(unvisited.size() == 0){
           throw new Error("No path to destination");
        }
        BFSData<T> deleted = unvisited.getFirst();
        unvisited.remove(deleted);
        visited.put(current.getVertex(), true);
        return searchDeep(deleted, end);
    }

    public boolean hasVisited(Vertex<T> current){
        return visited.get(current) != null ? true : false;
    }

    public boolean hasUnvisited(Vertex<T> current){
        for(BFSData<T> v : unvisited){
            if(v.getVertex().equals(current))
                return true;
        }

        return false;
    }

    @Override
    public ArrayList<Vertex<T>> search(Vertex<T> start, Vertex<T> end) {
        ArrayList<Vertex<T>> path = new ArrayList<Vertex<T>>();
        BFSData<T> bfsIterator = searchDeep(new BFSData<>(start, null, 0), end);
        while(bfsIterator.getParent() != null){
            path.add(bfsIterator.getVertex());
            bfsIterator = bfsIterator.getParent();
        }
        path.add(bfsIterator.getVertex());
        Collections.reverse(path);
        return path;
    }

}
