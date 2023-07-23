package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс фильтр, метод filter() представляет собой фильтр,
 * удаляет из списка перелётов те сегменты,
 * у которых дата вылета (departureDate) в прошлом.
 */
public class DepartureBeforeCurrentDateTimeFilter implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isAfter(currentDateTime)))
                .collect(Collectors.toList());

    }
}
