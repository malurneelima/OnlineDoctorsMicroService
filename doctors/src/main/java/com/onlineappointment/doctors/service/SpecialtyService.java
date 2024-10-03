package com.onlineappointment.doctors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineappointment.doctors.entity.Specialty;
import com.onlineappointment.doctors.exception.ServiceUnavailableException;
import com.onlineappointment.doctors.repository.SpecialtyRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @CircuitBreaker(name="saveSpecialtydb", fallbackMethod = "saveSpecialtyFallback")
    public Specialty saveSpecialty(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }
    
    public Specialty saveSpecialtyFallback(Specialty specialty,Throwable throwable) {
        System.out.println("Fallback occured for saveSpecialty due to :"+throwable.getMessage());
        throw new ServiceUnavailableException("DB connection");
    }
    
    @CircuitBreaker(name="getAllSpecialtiesdb", fallbackMethod = "getAllSpecialtiesFallback")
    public List<Specialty> getAllSpecialties() {
        return specialtyRepository.findAll();
    }
    
    public Specialty getAllSpecialtiesFallback(Specialty specialty,Throwable throwable) {
        System.out.println("Fallback occured for getAllSpecialties due to :"+throwable.getMessage());
        throw new ServiceUnavailableException("DB connection");
    }
}
