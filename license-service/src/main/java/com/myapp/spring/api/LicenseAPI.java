package com.myapp.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.License;
import com.myapp.spring.service.LicenseService;

@RestController
@RequestMapping(value = "api/v1/license")
public class LicenseAPI {
	

	@Autowired
	private LicenseService licenseService;

	@RequestMapping(value="/{licenseId}/{organizationId}",method = RequestMethod.GET)
	public ResponseEntity<License> getLicense( @PathVariable("organizationId") String organizationId,
			@PathVariable("licenseId") String licenseId) {

		License license = licenseService.getLicense(licenseId, organizationId, "");
		

		return ResponseEntity.ok(license);
	}

//	@RequestMapping(value="/{licenseId}/{clientType}",method = RequestMethod.GET)
//	public License getLicensesWithClient( @PathVariable("organizationId") String organizationId,
//			@PathVariable("licenseId") String licenseId,
//			@PathVariable("clientType") String clientType) {
//
//		return licenseService.getLicense(licenseId, organizationId, clientType);
//	}

	@PutMapping
	public ResponseEntity<License> updateLicense(@RequestBody License request) {
		return ResponseEntity.ok(licenseService.updateLicense(request));
	}

	@PostMapping
	public ResponseEntity<License> createLicense(@RequestBody License request) {
		return ResponseEntity.ok(licenseService.createLicense(request));
	}

	@DeleteMapping(value="/{licenseId}")
	public ResponseEntity<String> deleteLicense(@PathVariable("licenseId") String licenseId) {
		return ResponseEntity.ok(licenseService.deleteLicense(licenseId));
	}

	@RequestMapping(value="/organization/{organizationId}",method = RequestMethod.GET)
	public List<License> getLicenses( @PathVariable("organizationId") String organizationId) {
		return licenseService.getLicensesByOrganization(organizationId);
	}


}
