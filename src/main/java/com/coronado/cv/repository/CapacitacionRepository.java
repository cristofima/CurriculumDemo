package com.coronado.cv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coronado.cv.model.Capacitacion;


@Repository
public interface CapacitacionRepository extends JpaRepository<Capacitacion, Integer> {
	List<Capacitacion> findByUserId(int userId);
}
