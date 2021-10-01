package com.myapp.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, String>{

	
}
