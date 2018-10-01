package com.facebook;

import java.util.*;

public class Itinerary {
    public static class Flights {
        String startingAirport;
        String endingAirport;

        public Flights(String startingAirport, String endingAirport) {
            this.startingAirport = startingAirport;
            this.endingAirport = endingAirport;
        }
    }

    public static List<String> findItinerary(List<Flights> flights, String startingAirport) {
        if (flights == null || flights.size() == 0 || startingAirport == null || startingAirport == "")
            return null;
        HashSet<String> visited = new HashSet<>();

        // find the desitinaton from a starting airport.
        List<String> bestItinerary = findNextStop(flights, startingAirport);

        return bestItinerary == null || bestItinerary.size() != flights.size() + 1 ? null : bestItinerary;
    }

    private static List<String> findNextStop(List<Flights> flights, String startingAirPort) {
        List<String> bestPath = null;
        if (flights.size() == 0) {
            bestPath = new ArrayList<>();
            bestPath.add(startingAirPort);
            return bestPath;
        }
        for (Flights flight : flights) {
            if (startingAirPort.equals(flight.startingAirport)) {
                List<String> path = new ArrayList<>();
                List<Flights> leftFlights = new ArrayList<>();
                leftFlights.addAll(flights);
                leftFlights.remove(flight);
                path.add(flight.startingAirport);
                List<String> subBestPath = findNextStop(leftFlights, flight.endingAirport);
                path.addAll(subBestPath);
                if (subBestPath == null)
                    continue;
                else if (bestPath == null) {
                    bestPath = path;
                } else {
                    boolean isBetter = true;
                    for (int i = 0; i < bestPath.size(); i++) {
                        if (path.get(i).compareTo(bestPath.get(i)) > 0) {
                            isBetter = false;
                            break;
                        }
                    }
                    if (isBetter)
                        bestPath = path;
                }
            }
        }
        return bestPath;
    }
}
