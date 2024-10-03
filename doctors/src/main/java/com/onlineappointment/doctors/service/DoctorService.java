package com.onlineappointment.doctors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineappointment.doctors.entity.Doctors;
import com.onlineappointment.doctors.exception.ResourceNotFoundException;
import com.onlineappointment.doctors.exception.ServiceUnavailableException;
import com.onlineappointment.doctors.repository.DoctorRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@CircuitBreaker(name="saveDoctordb",fallbackMethod = "saveDoctorFallback")
	public Doctors saveDoctor(Doctors doctor) {
		return doctorRepository.save(doctor);
	}
	
	public Doctors saveDoctorFallback(Doctors doctor,Throwable throwable) {
		System.out.println("Fallback method triggered for saveDoctor as :"+throwable.getMessage());
    	 throw new ServiceUnavailableException("DB service");
	}

	public Doctors getDoctorById(Long id) {
		return doctorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("getDoctorById", "id", id));
	}

	@CircuitBreaker(name="getAllDoctorsdb",fallbackMethod = "getAllDoctorsFallback")
	public List<Doctors> getAllDoctors() {
		return doctorRepository.findAll();
	}
	public List<Doctors> getAllDoctorsFallback(Throwable throwable) {
		System.out.println("Fallback method triggered for getAllDoctors as :"+throwable.getMessage());
     	 throw new ServiceUnavailableException("DB service");
	}

	public Doctors updateDoctor(Long id, Doctors doctor) {
		doctorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("updateDoctor", "id", id));
		doctor.setId(id);
		return doctorRepository.save(doctor);
	}

	public void deleteDoctor(Long id) {
		doctorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("deleteDoctor", "id", id));
			doctorRepository.deleteById(id);
	}
}
