package com.controllers;

import com.entities.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.services.AirportService;
import springfox.documentation.annotations.ApiIgnore;

public class AirportController {

    @Autowired
    private AirportService airportService;

    //list
    @GetMapping(value = "/airports", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Airport> list(Model model) {
        return airportService.listAllAirports();
    }

    ////for redirect
    @ApiIgnore
    @RequestMapping(value = "/airports", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Airport> redirect(Model model) {
        return airportService.listAllAirports();
    }

    //List by id path
    @GetMapping(value = "/airport/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Airport getByPublicId(@PathVariable("id")Integer publicId) {
        return airportService.getAirportById(publicId).orElseGet(null);
    }
    //List by id param
    @GetMapping(value = "/airport", produces = MediaType.APPLICATION_JSON_VALUE)
    public Airport getByParamPublicId(@RequestParam("id")Integer publicId) {
        return  airportService.getAirportById(publicId).orElseGet(null);
    }
    //Save
    @PostMapping("/airport")
    public ResponseEntity<Airport> create(@RequestBody @NonNull Airport airport){
        airportService.saveAirport(airport);
        return ResponseEntity.ok().body(airport);
    }
    //Edit
    @PutMapping(value = "/airport/{id}")
    public  ResponseEntity<Void> edit(@RequestBody Airport airport) {
        if (!airportService.checkExistance(airport.getId())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.CREATED);

        }
    }
    //Delete
    @DeleteMapping(value = "/product/{id}")
    public  ResponseEntity delete(@PathVariable Integer id) {
        airportService.deleteAirport(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
