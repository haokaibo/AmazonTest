package facebook;

import com.facebook.Itinerary;
import com.facebook.Itinerary.Flights;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ItineraryTest extends TestCase {
    private Itinerary itinerary;

    @Before
    public void initialize() {
        itinerary = new Itinerary();
    }

    @Test
    public void testFindItinerary() {
        List<Flights> flights = new ArrayList<Flights>();
        flights.add(new Flights("A", "B"));
        flights.add(new Flights("A", "C"));
        flights.add(new Flights("B", "C"));
        flights.add(new Flights("C", "A"));

        String startingAirport = "A";
        List<String> result = Itinerary.findItinerary(flights, startingAirport);
        if (result != null)
            for (String s : result) {
                System.out.println(s);
            }
    }

    @Test
    public void testFindItinerary2() {
        List<Flights> flights = new ArrayList<Flights>();
        flights.add(new Flights("SFO", "HKO"));
        flights.add(new Flights("YYZ", "SFO"));
        flights.add(new Flights("YUL", "YYZ"));
        flights.add(new Flights("HKO", "ORD"));

        String startingAirport = "YUL";
        List<String> result = Itinerary.findItinerary(flights, startingAirport);
        if (result != null)
            for (String s : result) {
                System.out.println(s);
            }
    }

    @Test
    public void testFindItineraryWithNullReturn() {
        List<Flights> flights = new ArrayList<Flights>();
        flights.add(new Flights("SFO", "COM"));
        flights.add(new Flights("COM", "YYZ"));

        String startingAirport = "COM";
        List<String> result = Itinerary.findItinerary(flights, startingAirport);
        assertEquals(null, result);
    }
}
