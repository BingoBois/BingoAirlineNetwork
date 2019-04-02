package search.IO;

public class Main {
    public static void main(String[] args) {
        AirlineReader file = new AirlineReader();
        AirportReader file2 = new AirportReader();
        AircraftReader file3 = new AircraftReader();
        RouteReader file4 = new RouteReader();
        System.out.println(file.readAirlines().size());
        System.out.println(file2.readAirport().size());
        System.out.println(file3.readAircrafts().size());
        System.out.println(file4.readRoutes().size());
    }
}
