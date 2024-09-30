package com.onlineappointment.doctors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineappointment.doctors.entity.Availability;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
	List<Availability> findByDoctorId(Long doctorId);
}
