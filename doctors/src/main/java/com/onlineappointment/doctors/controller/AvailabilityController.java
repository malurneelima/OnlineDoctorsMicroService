package com.onlineappointment.doctors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.onlineappointment.doctors.entity.Availability;
import com.onlineappointment.doctors.service.AvailabilityService;

import java.util.List;

@RestController
@RequestMapping("/api/availabilities")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    @PostMapping
    public ResponseEntity<Availability> createAvailability(@RequestBody Availability availability) {
        Availability savedAvailability = availabilityService.saveAvailability(availability);
        return new ResponseEntity<>(savedAvailability, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Availability>> getAllAvailabilities() {
        List<Availability> availabilities = availabilityService.getAllAvailabilities();
        return new ResponseEntity<>(availabilities, HttpStatus.OK);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Availability>> getAvailabilitiesByDoctorId(@PathVariable Long doctorId) {
        List<Availability> availabilities = availabilityService.getAvailabilitiesByDoctorId(doctorId);
        return new ResponseEntity<>(availabilities, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvailability(@PathVariable Long id) {
        boolean isDeleted = availabilityService.deleteAvailability(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) 
                         : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

