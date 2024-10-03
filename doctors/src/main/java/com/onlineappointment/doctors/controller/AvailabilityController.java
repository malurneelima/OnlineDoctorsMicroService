package com.onlineappointment.doctors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineappointment.doctors.entity.Availability;
import com.onlineappointment.doctors.service.AvailabilityService;

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
    public ResponseEntity<String> deleteAvailability(@PathVariable Long id) {
       availabilityService.deleteAvailability(id);
       return new ResponseEntity<>("User Successfully Deleted",HttpStatus.OK); 
                        
    }
}

