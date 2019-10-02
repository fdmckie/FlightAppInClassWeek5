package com.example.demo;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=3)
    private String beginAirport;

    @NotNull
    @Size(min=3)
    private String endingAirport;

    @NotNull
    private String price;

    @NotNull
    private String airlineName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Flight() {
    }

    public Flight(@NotNull @Size(min = 3) String beginAirport, @NotNull @Size(min = 3) String endingAirport, @NotNull String price, @NotNull String airlineName, Date date) {
        this.beginAirport = beginAirport;
        this.endingAirport = endingAirport;
        this.price = price;
        this.airlineName = airlineName;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBeginAirport() {
        return beginAirport;
    }

    public void setBeginAirport(String beginAirport) {
        this.beginAirport = beginAirport;
    }

    public String getEndingAirport() {
        return endingAirport;
    }

    public void setEndingAirport(String endingAirport) {
        this.endingAirport = endingAirport;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
