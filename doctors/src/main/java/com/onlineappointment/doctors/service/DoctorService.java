package com.onlineappointment.doctors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineappointment.doctors.entity.Doctors;
import com.onlineappointment.doctors.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	public Doctors saveDoctor(Doctors doctor) {
		return doctorRepository.save(doctor);
	}

	public Doctors getDoctorById(Long id) {
		return doctorRepository.findById(id).orElse(null);
	}

	public List<Doctors> getAllDoctors() {
		return doctorRepository.findAll();
	}

	public Doctors updateDoctor(Long id, Doctors doctor) {
		if (doctorRepository.existsById(id)) {
			doctor.setId(id);
			return doctorRepository.save(doctor);
		}
		return null;
	}

	public boolean deleteDoctor(Long id) {
		if (doctorRepository.existsById(id)) {
			doctorRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
