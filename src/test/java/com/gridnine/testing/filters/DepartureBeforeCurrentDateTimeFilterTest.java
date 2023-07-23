package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.gridnine.testing.FlightBuilder.createFlight;
import static org.junit.Assert.assertEquals;

public class DepartureBeforeCurrentDateTimeFilterTest {
    @Test
    void testFilter() {
        DepartureBeforeCurrentDateTimeFilter filter = new DepartureBeforeCurrentDateTimeFilter();


        List<Flight> flights = Arrays.asList(

                createFlight(LocalDateTime.now().minusHours(2), LocalDateTime.now().plusHours(1)),

                createFlight(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(2))
        );

        List<Flight> filteredFlights = filter.filter(flights);
        assertEquals(1, filteredFlights.size());
    }
}
