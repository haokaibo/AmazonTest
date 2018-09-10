package com.google;

import java.util.ArrayList;
import java.util.List;

/*
Flight itinerary problem

The flight itinerary problem is as follows:

Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, and a starting
airport, compute the person's itinerary. If no such itinerary exists, return null. All flights must be used in the
itinerary.

For example, given the following list of flights:

HNL ➔ AKL
YUL ➔ ORD
ORD ➔ SFO
SFO ➔ HNL
and starting airport YUL, you should return YUL ➔ ORD ➔ SFO ➔ HNL ➔ AKL. (This also happens to be the actual itinerary
 for the trip I'm about to take.)

You should take some time to try to solve it on your own! Notice that a greedy solution won't work, since it's possible
to have a cycle in the graph.

Let's again describe the brute force solution to this problem, which is to try every permutation of flights and verify
that it's a valid itinerary. That would be O(n!). Now let's ask ourselves if we can improve this with backtracking.

Can we construct a partial solution?

Yes, we can build an (incomplete) itinerary and extend it by adding more flights to the end.

Can we verify if the partial solution is invalid?

Yes, we can check a solution is invalid if 1) there are no flights leaving from our last destination and 2) there are
still flights remaining that can be taken. Since we must use all flights, this means we're at a dead end.

Can we verify if the solution is complete?

Yes, we can check if a solution is complete if our itinerary uses all the flights.

Let's use this to construct our solution:

def get_itinerary(flights, current_itinerary):
    # If we've used up all the flights, we're done
    if not flights:
        return current_itinerary
    last_stop = current_itinerary[-1]
    for i, (origin, destination) in enumerate(flights):
        # Make a copy of flights without the current one to mark it as used
        flights_minus_current = flights[:i] + flights[i + 1:]
        current_itinerary.append(destination)
        if origin == last_stop:
            return get_itinerary(flights_minus_current, current_itinerary)
        current_itinerary.pop()
    return None
 */
public class FlightItinerary {
    class Flight {
        String origin;
        String destination;

        Flight(String orgin, String destination) {
            this.origin = orgin;
            this.destination = destination;
        }
    }

    public static void getItinerary(List<Flight> flights, List<String> currentItinerary) {
        if (flights == null || flights.size() == 0)
            return;
        String lastStop = currentItinerary.get(currentItinerary.size() - 1);
        for (Flight flight : flights) {
            List<Flight> flightsExcludeCurrent = new ArrayList<>(flights);
            flightsExcludeCurrent.remove(flight);

            if (flight.origin == lastStop) {
                currentItinerary.add(flight.destination);
                getItinerary(flightsExcludeCurrent, currentItinerary);
            }
        }
        return;
    }

    public List<Flight> buildFlights() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("D", "E"));
        flights.add(new Flight("A", "B"));
        flights.add(new Flight("B", "C"));
        flights.add(new Flight("C", "D"));
        return flights;
    }

    public static void main(String[] main) {
        List<Flight> flights = new FlightItinerary().buildFlights();


        for (Flight flight : flights) {
            List<String> itinerary = new ArrayList<>();
            itinerary.add(flight.origin);
            itinerary.add(flight.destination);
            getItinerary(flights, itinerary);
            if (itinerary.size() - 1 == flights.size()) {
                for (int i=0; i<itinerary.size();i++) {
                    if (i==itinerary.size()-1)
                        System.out.printf("%s.", itinerary.get(i));
                    else
                        System.out.printf("%s -> ", itinerary.get(i));
                }
                System.out.println();
            }
        }
    }

}
