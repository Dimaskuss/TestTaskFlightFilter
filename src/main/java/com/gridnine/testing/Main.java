package com.gridnine.testing;

import com.gridnine.testing.filters.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.filters.DepartureBeforeCurrentDateTimeFilter;
import com.gridnine.testing.filters.FlightFilter;
import com.gridnine.testing.filters.GroundTimeExceedsFilter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter departureFilter = new DepartureBeforeCurrentDateTimeFilter();
        FlightFilter arrivalFilter = new ArrivalBeforeDepartureFilter();
        FlightFilter groundTimeFilter = new GroundTimeExceedsFilter();

        // Фильтрация и вывод результатов
        System.out.println("Перелёты с вылетом до текущего момента времени:");
        printFlights(departureFilter.filter(flights));

        System.out.println("\nПерелёты с сегментами, у которых дата прилёта раньше даты вылета:");
        printFlights(arrivalFilter.filter(flights));

        System.out.println("\nПерелёты с общим временем на земле более 2 часов:");
        printFlights(groundTimeFilter.filter(flights));
    }

    private static void printFlights(List<Flight> flights) {
        flights.forEach(flight -> System.out.println(flight.toString()));
    }
}