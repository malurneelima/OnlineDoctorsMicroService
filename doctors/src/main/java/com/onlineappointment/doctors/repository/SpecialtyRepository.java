package com.onlineappointment.doctors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineappointment.doctors.entity.Specialty;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
	 Specialty findByName(String name);
}
