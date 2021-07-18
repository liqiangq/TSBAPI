package com.nz.tsb.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nz.tsb.springboot.model.Vehicle;
import com.sipios.springsearch.anotation.SearchSpec;
import com.nz.tsb.springboot.repository.IVehicleRepository;

@RestController
public class VehicleController {

	@Autowired
	IVehicleRepository vehicleRepo;

	// create a vehicle
	@PostMapping("/vehicles")
	public ResponseEntity<Vehicle> save(@RequestBody Vehicle vehicle) {
		try {
			return new ResponseEntity<>(vehicleRepo.save(vehicle), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// get all vehicles
	@GetMapping("/vehicles")
	public ResponseEntity<List<Vehicle>> getAllVehicles() {
		try {
			List<Vehicle> list = vehicleRepo.findAll();
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<Vehicle>>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<List<Vehicle>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// get vehicle by id rest api
	@GetMapping("/vehicles/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
		Optional<Vehicle> vehicle = vehicleRepo.findById(id);

		if (vehicle.isPresent()) {
			return new ResponseEntity<Vehicle>(vehicle.get(), HttpStatus.OK);
		}

		return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
	}

	// Update vehicle by id
	@PutMapping("/vehicles/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle) {
		try {
			return new ResponseEntity<Vehicle>(vehicleRepo.save(vehicle), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/vehicles/{id}")
	public ResponseEntity<Vehicle> deleteVehicle(@PathVariable Long id) {
		try {
			Optional<Vehicle> vehicle = vehicleRepo.findById(id);

			if (vehicle.isPresent()) {
				vehicleRepo.delete(vehicle.get());
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/vehicles/search")
	public ResponseEntity<List<Vehicle>> search(@SearchSpec Specification<Vehicle> specs) {
		try {
			List<Vehicle> list = vehicleRepo.findAll(Specification.where(specs));
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<Vehicle>>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<List<Vehicle>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
