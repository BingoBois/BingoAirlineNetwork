package search.Opg2Dijkstra;

public class HeapType {
    
    private double distance;
    private String airCode;
    private HeapType parent;

    public HeapType(String airCode, double distance, HeapType parent) {
        this.distance = distance;
        this.airCode = airCode;
        this.parent = parent;
    }

    public double getDistance() {
        return distance;
    }

    public String getAirCode() {
        return airCode;
    }

    public HeapType getParent() {
        return parent;
    }


}
