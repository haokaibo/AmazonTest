package facebook;

import com.amazon.Anagrams;
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
}
