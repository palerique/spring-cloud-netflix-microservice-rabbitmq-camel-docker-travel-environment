package br.com.sitedoph.travelenvironment.domain;

import com.google.common.base.MoreObjects;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by ph on 6/22/16.
 */
public class Flight {

    private final String from;
    private final String to;
    private final String aircraft;
    private final LocalDateTime departureTime;
    private final String flightNumber;

    public Flight(String from, String to, String aircraft, LocalDateTime departureTime, String flightNumber) {
        this.from = from;
        this.to = to;
        this.aircraft = aircraft;
        this.departureTime = departureTime;
        this.flightNumber = flightNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return Objects.equals(from, flight.from) &&
                Objects.equals(to, flight.to) &&
                Objects.equals(aircraft, flight.aircraft) &&
                Objects.equals(departureTime, flight.departureTime) &&
                Objects.equals(flightNumber, flight.flightNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, aircraft, departureTime, flightNumber);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("from", from)
                .add("to", to)
                .add("aircraft", aircraft)
                .add("departureTime", departureTime)
                .add("flightNumber", flightNumber)
                .toString();
    }
}
