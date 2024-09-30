package com.onlineappointment.doctors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineappointment.doctors.entity.Specialty;
import com.onlineappointment.doctors.repository.SpecialtyRepository;

import java.util.List;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    public Specialty saveSpecialty(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    public List<Specialty> getAllSpecialties() {
        return specialtyRepository.findAll();
    }
}
