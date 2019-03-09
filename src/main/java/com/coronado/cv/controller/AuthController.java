package com.coronado.cv.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coronado.cv.exception.ConflictException;
import com.coronado.cv.exception.ServerException;
import com.coronado.cv.model.Role;
import com.coronado.cv.model.User;
import com.coronado.cv.payload.request.LoginForm;
import com.coronado.cv.payload.request.SignUpForm;
import com.coronado.cv.payload.response.JwtResponse;
import com.coronado.cv.repository.RoleRepository;
import com.coronado.cv.repository.UserRepository;
import com.coronado.cv.security.jwt.JwtProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		return ResponseEntity.ok(new JwtResponse(jwt));
	}

	@PostMapping("/signup")
	public ResponseEntity<Object> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			throw new ConflictException("Username " + signUpRequest.getUsername() + " is already taken!");
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			throw new ConflictException("Email " + signUpRequest.getEmail() + " is already in use!");
		}

		Date today = new Date();
		// Creating user's account
		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<Role> roles = new HashSet<>();

		Optional<Role> userRole = roleRepository.findByName("ROLE_USER");
		if (!userRole.isPresent()) {
			throw new ServerException("Cause: User Role not find.");
		}

		roles.add(userRole.get());

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok().build();
	}
}
