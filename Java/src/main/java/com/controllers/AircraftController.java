package com.controllers;

import entities.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.AircraftService;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api")
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    //list
    @GetMapping(value = "/aircrafts", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Aircraft> list(Model model) {
        return aircraftService.listAllAircrafts();
    }

    ////for redirect
    @ApiIgnore
    @RequestMapping(value = "/aircrafts", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Aircraft> redirect(Model model) {
        return aircraftService.listAllAircrafts();
    }

    //List by id path
    @GetMapping(value = "/aircraft/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Aircraft getByPublicId(@PathVariable("id")Integer publicId) {
        return aircraftService.getAircraftById(publicId).orElseGet(null);
    }
    //List by id param
    @GetMapping(value = "/aircraft", produces = MediaType.APPLICATION_JSON_VALUE)
    public Aircraft getByParamPublicId(@RequestParam("id")Integer publicId) {
        return  aircraftService.getAircraftById(publicId).orElseGet(null);
    }
    //Save
    @PostMapping("/aircraft")
    public ResponseEntity<Aircraft> create(@RequestBody @NonNull Aircraft aircraft){
        aircraftService.saveAircraft(aircraft);
        return ResponseEntity.ok().body(aircraft);
    }
    //Edit
    @PutMapping(value = "/aircraft/{id}")
    public  ResponseEntity<Void> edit(@RequestBody Aircraft aircraft) {
        if (!aircraftService.checkExistance(aircraft.getId())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.CREATED);

        }
    }
    //Delete
    @DeleteMapping(value = "/product/{id}")
    public  ResponseEntity delete(@PathVariable Integer id) {
        aircraftService.deleteAircraft(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}