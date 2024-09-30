package com.onlineappointment.doctors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineappointment.doctors.entity.Doctors;

@Repository
public interface DoctorRepository extends JpaRepository<Doctors, Long> {
  
}

