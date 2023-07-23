package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrivalBeforeDepartureFilterTest {

    @Test
    void testFilter() {
        ArrivalBeforeDepartureFilter filter = new ArrivalBeforeDepartureFilter();


        List<Flight> flights = Arrays.asList(
                new Flight(Arrays.asList(
                        new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(1)),
                        new Segment(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(2))
                )),
                new Flight(Arrays.asList(
                        new Segment(LocalDateTime.now().plusHours(4), LocalDateTime.now().plusHours(3)),
                        new Segment(LocalDateTime.now().plusHours(5), LocalDateTime.now().plusDays(1))
                ))
        );

        List<Flight> filteredFlights = filter.filter(flights);
        assertEquals(0, filteredFlights.size());
    }
}