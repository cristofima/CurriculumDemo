package com.coronado.cv.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coronado.cv.model.Capacitacion;
import com.coronado.cv.repository.CapacitacionRepository;
import com.coronado.cv.security.CurrentUser;
import com.coronado.cv.security.UserPrincipal;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/capacitaciones")
public class CapacitacionController {

	@Autowired
	private CapacitacionRepository capacitacionRepository;

	@GetMapping
	public List<Capacitacion> getCapacitaciones(@CurrentUser UserPrincipal currentUser) {
		return capacitacionRepository.findByUserId(currentUser.getId());
	}

	@PostMapping()
	public Capacitacion createCapacitacion(@Valid @RequestBody Capacitacion capacitacion) {
		return capacitacionRepository.save(capacitacion);
	}
}
