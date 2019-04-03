// package spanningtree;

// import graphs.Vertex;

// import java.util.ArrayList;
// import java.util.HashMap;

// public class Graph<T extends Comparable<T>> {
//     // 1. The airport lookup code
//     // 2. Airport vertex itself links to:
//     // 3. Airport hashmap for airport lookup codes adjacent to the vertex, which links to
//     // 4. Weight
//     private HashMap<String, HashMap<Vertex<T>, HashMap<String, HashMap<Vertex<T>, Double>>>> graph = new HashMap<>();

//     public void addUniEdge(String airportCodeA, Vertex<T> vertexB, double weight){
//         HashMap<Vertex<T>, Double> tmpHash = graph.get(vertexA);
//         if (tmpHash == null){
//             tmpHash = new HashMap<>();
//         }
//         tmpHash.put(vertexB, weight);
//         graph.put(vertexA, tmpHash);
//     }

//     public void addBiEdge(Vertex<T> vertexA, Vertex<T> vertexB, Double weight){
//         addUniEdge(vertexA, vertexB, weight);
//         addUniEdge(vertexB, vertexA, weight);
//     }

//     public void addWithNoEdge(Vertex<T> vertexA) {
//         graph.put(vertexA, null);
//     }

//     public boolean hasEdge(Vertex<T> vertexA, Vertex<T> vertexB) {
//         HashMap<Vertex<T>, Boolean> tmpHash = graph.get(vertexA);
//         if (tmpHash == null){
//             return false;
//         }
//         return tmpHash.get(vertexB);
//     }

//     public int getDegree(Vertex<T> vertex){
//         return graph.get(vertex).size();
//     }

//     public ArrayList<Vertex<T>> getAdjacent(Vertex<T> vertex){
//         return (ArrayList<Vertex<T>>) graph.get(vertex).keySet();
//     }

//     @Override
//     public String toString(){
//         StringBuilder strBuilder = new StringBuilder();
//         strBuilder.append("[\n");
//         for (Vertex<T> vertex : graph.keySet()) {
//             strBuilder.append(vertex.toString());
//             HashMap<Vertex<T>, Boolean> hm = graph.get(vertex);
//             for(Vertex<T> e : hm.keySet()){
//                 strBuilder.append(" { ");
//                 strBuilder.append(e.toString());
//                 strBuilder.append(" },");
//             }
//             strBuilder.append("\n");
//         }
//         strBuilder.append("]\n");
//         return strBuilder.toString();
//     }
// }
