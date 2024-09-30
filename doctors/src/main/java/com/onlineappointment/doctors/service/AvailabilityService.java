package com.onlineappointment.doctors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineappointment.doctors.entity.Availability;
import com.onlineappointment.doctors.repository.AvailabilityRepository;

@Service
public class AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    public Availability saveAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    public List<Availability> getAllAvailabilities() {
        return availabilityRepository.findAll();
    }

    public List<Availability> getAvailabilitiesByDoctorId(Long doctorId) {
        return availabilityRepository.findByDoctorId(doctorId);
    }

    public boolean deleteAvailability(Long id) {
        if (availabilityRepository.existsById(id)) {
            availabilityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

