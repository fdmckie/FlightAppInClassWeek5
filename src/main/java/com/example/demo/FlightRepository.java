package com.example.demo;


import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface FlightRepository extends CrudRepository<Flight, Long> {

//    ArrayList<Message> findByTitleContainingIgnoreCase(String title);

    ArrayList<Flight> findByBeginAirportContainingIgnoreCase(String beginAirport);
    ArrayList<Flight> findByEndingAirportContainingIgnoreCase(String endingAirport);

}
