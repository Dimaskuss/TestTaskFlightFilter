package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс фильтр, метод filter()
 * убирает из списка перелетов перелеты
 * с временем ожидания между сегментами более 2х часов.
 */
public class GroundTimeExceedsFilter implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    for (int i = 0; i < segments.size() - 1; i++) {
                        Segment currentSegment = segments.get(i);
                        Segment nextSegment = segments.get(i + 1);
                        if (Duration.between(currentSegment.getArrivalDate(), nextSegment.getDepartureDate()).toHours() <= 2) {
                            return false;
                        }
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }


}
