package search.Opg3Dijkstra;

public class HeapType {

    private double time;
    private String airCode;
    private HeapType parent;

    public HeapType(String airCode, double time, HeapType parent) {
        this.time = time;
        this.airCode = airCode;
        this.parent = parent;
    }

    public double getTime() {
        return time;
    }

    public String getAirCode() {
        return airCode;
    }

    public HeapType getParent() {
        return parent;
    }


}
