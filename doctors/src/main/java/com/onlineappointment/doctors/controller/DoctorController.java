package com.onlineappointment.doctors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineappointment.doctors.entity.Doctors;
import com.onlineappointment.doctors.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Doctors> createDoctor(@RequestBody Doctors doctor) {
        Doctors savedDoctor = doctorService.saveDoctor(doctor);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctors> getDoctorById(@PathVariable Long id) {
        Doctors doctor = doctorService.getDoctorById(id);
        return  new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Doctors>> getAllDoctors() {
        List<Doctors> doctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctors> updateDoctor(@PathVariable Long id, @RequestBody Doctors doctor) {
        Doctors updatedDoctor = doctorService.updateDoctor(id, doctor);
        return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
    	doctorService.deleteDoctor(id);
        return new ResponseEntity<>("Doctor deleted successfully",HttpStatus.OK);
    }
    
    
}
