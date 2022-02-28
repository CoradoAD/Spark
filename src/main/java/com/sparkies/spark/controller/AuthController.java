package com.sparkies.spark.controller;

import java.security.GeneralSecurityException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparkies.spark.model.Energy;
import com.sparkies.spark.model.TypeVehicle;
import com.sparkies.spark.model.User;
import com.sparkies.spark.model.Vehicle;
import com.sparkies.spark.payload.request.LoginRequest;
import com.sparkies.spark.payload.request.SignupRequest;
import com.sparkies.spark.payload.response.JwtResponse;
import com.sparkies.spark.payload.response.MessageResponse;
import com.sparkies.spark.repository.EnergyRepo;
import com.sparkies.spark.repository.RoleRepository;
import com.sparkies.spark.repository.UserRepo;
import com.sparkies.spark.security.jwt.JwtUtils;
import com.sparkies.spark.security.jwt.service.UserDetailsImpl;
import com.sparkies.spark.service.EnergyService;
import com.sparkies.spark.service.VehicleService;
import com.sparkies.spark.service.impl.EnergyServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/auth")

public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepo userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	EnergyService energyService; 

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
		System.out.println(loginRequest.getuserPwd());
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getuserPwd()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {

		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByUserEmail(signUpRequest.getUserEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), signUpRequest.getUserEmail(),
				encoder.encode(signUpRequest.getUserPwd()));
		Vehicle vehicle = new Vehicle(null, 0L, null);
		Energy energy = energyService.getOneEnergy(1L).get();
		

		userRepository.save(user);
		vehicleService.addVehiculeByUser(vehicle, TypeVehicle.voiture, energy, user);
		
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	@GetMapping("/connected")
    public boolean isjwtValid(@RequestHeader(value="Authorization",required=false) String token) throws GeneralSecurityException {
        if(token.startsWith("Bearer ")) {
            String tokenCut =token.substring(7,token.length());
            Boolean respToken = jwtUtils.validateJwtToken(tokenCut);
            return respToken;
                }
        
        return false;
        
    }
}
