package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс фильтр, метод filter()
 * удаляет из списка перелётов те, у которых дата прилёта (arrivalDate)
 * раньше даты вылета (departureDate) хотя бы в одном сегменте.
 */
public class ArrivalBeforeDepartureFilter implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }

}
