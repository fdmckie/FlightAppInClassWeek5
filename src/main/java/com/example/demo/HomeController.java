package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.NumberFormat;

@Controller
public class HomeController {

    @Autowired
    FlightRepository flightRepository;

    @RequestMapping("/")
    public String messageList(Model model) {
        model.addAttribute("flights", flightRepository.findAll());
        return "flightlist";
    }

    @GetMapping("/add")
    public String addFlight(Model model) {
        model.addAttribute("flight", new Flight());
        return "flightform";
    }

    @PostMapping("/processflight")
    public String processForm(@ModelAttribute Flight flight, @RequestParam(name = "date")
            String date) {

//        , @RequestParam String price
//        NumberFormat flightCurrency = NumberFormat.getCurrencyInstance();
//        String priceAirflight = flightCurrency.format(price);
//        flight.setPrice(priceAirflight);


        String pattern = "yyyy-MM-dd";
        try {
            String formattedDate = date.substring(1, date.length() - 1);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date realDate = simpleDateFormat.parse(formattedDate);
            flight.setDate(realDate);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        flightRepository.save(flight);
        return "redirect:/";
    }

    @PostMapping("/processsearch")
    public String searchResult(Model model, @RequestParam(name = "search") String search) {
        model.addAttribute("flights", flightRepository.findByBeginAirportContainingIgnoreCase(search));
        return "searchlist";


    }

    @PostMapping("/processsearch2")
    public String searchResult2(Model model, @RequestParam(name = "search2") String search2) {
        model.addAttribute("flights", flightRepository.findByEndingAirportContainingIgnoreCase(search2));
        return "searchlist";


    }

}



