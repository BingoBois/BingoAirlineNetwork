package algo.Opg4MST;

import IO.MSTRouteReader;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Graph for EVERY Airline_code.
        // BIGGEST spanning tree wins (totalt distance)
        MSTRouteReader reader = new MSTRouteReader();
        HashMap<String, Graph<String>> graphs = reader.readRoutes();

        // The task itself makes no sense, and has nothing to do with source MST, widest coverage could simply just be the amount of vertexes an airline has.
        int largest = 0;
        String largestAirline = "";
        for (String air : graphs.keySet()) {
            if(graphs.get(air).getSize() > largest){
                largest = graphs.get(air).getSize();
                largestAirline = air;
            }
        }
        System.out.println("Widest coverage airline: " + largestAirline + ", amount of destinations:" + graphs.size());

        // And to actually try it with source MST, here we use Primm and select the biggest MST from all of them
        int largestSpanTree = 0;
        String largestDickStra = "";
        for (String g : graphs.keySet()) {
            Primm primm = new Primm(graphs.get(g));
            if (graphs.get(g).getSize() > largestSpanTree) {
                largestSpanTree = primm.getMST().getSize();
                largestDickStra = g;
            }
        }
        System.out.println("Whitest MST Size: " + largestDickStra + ", amount of destinations:" + largestSpanTree);
    }
}
