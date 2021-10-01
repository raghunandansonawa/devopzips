package com.myapp.spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Organization;
import com.myapp.spring.repository.OrganizationRepository;

@RestController
@RequestMapping(value = "api/v1/organization")
public class OrganizationAPI {
	
	@Autowired
	private OrganizationRepository repository;

	// http:IP:PORT/api/v1/organization/12345
	@GetMapping(value="/{organizationId}")
	public ResponseEntity<Organization> getOrganization(@PathVariable("organizationId") String organizationId){
		return ResponseEntity.ok(repository.findById(organizationId).get());
		
	}
	
	// http:IP:PORT/api/v1/organization
	// {"id":1,"name":"","":""}
	
	// insert into organizations values ()
	@PostMapping()
	public ResponseEntity<?> addNewOrganization(@RequestBody Organization organization){
		return new ResponseEntity<>(repository.save(organization),HttpStatus.CREATED);
		
	}

}
