package search.Opg1DepthFirst;

public class HeapType {

    private double jumps;
    private String airCode;
    private HeapType parent;

    public HeapType(String airCode, double jumps, HeapType parent) {
        this.jumps = jumps;
        this.airCode = airCode;
        this.parent = parent;
    }

    public double getJumps() {
        return jumps;
    }

    public String getAirCode() {
        return airCode;
    }

    public HeapType getParent() {
        return parent;
    }


}
