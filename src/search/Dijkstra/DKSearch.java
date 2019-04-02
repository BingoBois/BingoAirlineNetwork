package search.Dijkstra;

import graphs.IGraph;
import graphs.Vertex;
import search.ISearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class DKSearch<T extends Comparable<T>> implements ISearch<T> {
    private MinHeap<DKData<T>> unvisited = new MinHeap<DKData<T>>();
    private HashMap<Vertex<T>, Boolean> visited = new HashMap<>();
    private IGraph graph;
    /*
       er vi på end - Så er vi i mål - Ellers hopper vi videre til næste trin
       Hvert verteces består af forbundende verteces som den ikke har besøgt endnu
       Liste af verteces - Sorteret efter distance - For hvert iteration går vi videre til næste lag
       Tag første element i listen
    */
    public DKSearch(IGraph<T> graph){
        this.graph = graph;
    }

    public DKData<T> searchDeep(DKData<T> current, Vertex<T> end){
        if(current.getVertex().equals(end)){
            return current;
        }

        ArrayList<Vertex<T>> adjacent = graph.getAdjacent(current.getVertex());

        for(Vertex<T> data : adjacent){
            if(!hasVisited(data) && !isInUnvisited(data)){
                System.out.println("Adding vertex to unvisited " + data.toString());
                unvisited.enqueue(new DKData<>(data, current));
            }
            //unvisited.add(new DKData<>(data, current));
        }

        if(unvisited.size() == 0){
            throw new Error("No path to destination");
        }

        DKData<T> deleted = (DKData<T>) unvisited.dequeue();

        visited.put(current.getVertex(), true);
        return searchDeep(deleted, end);
    }

    public boolean hasVisited(Vertex<T> current){
        return visited.get(current) != null ? true : false;
    }

    public boolean isInUnvisited(Vertex<T> current){
        /*
        for(DKData<T> v : unvisited){
            if(v.getVertex().equals(current))
                return true;
        }
        */
        return false;
    }

    @Override
    public ArrayList<Vertex<T>> search(Vertex<T> start, Vertex<T> end) {
        ArrayList<Vertex<T>> path = new ArrayList<Vertex<T>>();
        DKData<T> bfsIterator = searchDeep(new DKData<>(start, null), end);
        while(bfsIterator.getParent() != null){
            path.add(bfsIterator.getVertex());
            bfsIterator = bfsIterator.getParent();
        }
        path.add(bfsIterator.getVertex());
        Collections.reverse(path);
        return path;
    }

}