package models;

public class Route {

    private String airlineCode, sourceCode, distinationCode;
    private double distance, time;

    public Route(String airlineCode, String sourceCode, String distinationCode, double distance, double time) {
        this.airlineCode = airlineCode;
        this.sourceCode = sourceCode;
        this.distinationCode = distinationCode;
        this.distance = distance;
        this.time = time;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getDistinationCode() {
        return distinationCode;
    }

    public void setDistinationCode(String distinationCode) {
        this.distinationCode = distinationCode;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
