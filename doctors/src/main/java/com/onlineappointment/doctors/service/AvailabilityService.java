package com.onlineappointment.doctors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineappointment.doctors.entity.Availability;
import com.onlineappointment.doctors.exception.ResourceNotFoundException;
import com.onlineappointment.doctors.exception.ServiceUnavailableException;
import com.onlineappointment.doctors.repository.AvailabilityRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;
    
    @CircuitBreaker(name = "saveAvailabilitydb",fallbackMethod = "saveAvailabilityFallback")
    public Availability saveAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }
    
    public Availability saveAvailabilityFallback(Availability availability,Throwable throwable) {
    	System.out.println("Fallback method triggered for saveAvailability as :"+throwable.getMessage());
      	 throw new ServiceUnavailableException("DB service");
    }
    
    @CircuitBreaker(name = "getAllAvailabilitiesdb",fallbackMethod = "getAllAvailabilitiesFallback")
    public List<Availability> getAllAvailabilities() {
        return availabilityRepository.findAll();
    }
    public Availability getAllAvailabilitiesFallback(Throwable throwable) {
    	System.out.println("Fallback method triggered for getAllAvailabilities as :"+throwable.getMessage());
      	 throw new ServiceUnavailableException("DB service");
    }

    public List<Availability> getAvailabilitiesByDoctorId(Long doctorId) {
        return availabilityRepository.findByDoctorId(doctorId);
    }

    public void deleteAvailability(Long id) {
    	availabilityRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("deleteAvailability","id",id));
            availabilityRepository.deleteById(id);
    }
}

