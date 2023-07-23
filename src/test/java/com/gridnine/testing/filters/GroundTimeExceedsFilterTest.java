package com.gridnine.testing.filters;

import org.junit.jupiter.api.Test;
import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.gridnine.testing.FlightBuilder.createFlight;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GroundTimeExceedsFilterTest {

    @Test
    void testFilter() {
        GroundTimeExceedsFilter filter = new GroundTimeExceedsFilter();


        List<Flight> flights = Arrays.asList(

                createFlight(LocalDateTime.now(), LocalDateTime.now().plusHours(1),
                        LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3)),

                createFlight(LocalDateTime.now(), LocalDateTime.now().plusHours(1),
                        LocalDateTime.now().plusHours(4), LocalDateTime.now().plusHours(5))
        );

        List<Flight> filteredFlights = filter.filter(flights);
        assertEquals(1, filteredFlights.size());
    }
}