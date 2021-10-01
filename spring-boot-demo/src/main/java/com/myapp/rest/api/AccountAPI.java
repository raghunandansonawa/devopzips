package com.myapp.rest.api;



import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.myapp.rest.exceptions.ResourceNotFoundException;
import com.myapp.rest.models.Account;
import com.myapp.rest.repository.AccountRepository;

// This is a Rest Resource
@RestController
@RequestMapping("api/v1")
public class AccountAPI {
	
	
	private static final String ACCOUNT_NOT_FOUND= "Unable To Find The Account Number";
	
	// Account API 
	// Dependency Injection
	
	@Autowired
	private AccountRepository repository ;
	
	@Autowired
	private ObjectMapper mapper;
	
	
	// http://IP:PORT/api/v1/accounts
//	@PostMapping("/accounts")
//	public ResponseEntity<?> findAccountBalance(@Valid   @RequestBody  AccountInput input){
//		Optional<Account>  account =repository.findByAccountNumber(input.getAccountNumber());
//		return new ResponseEntity<>(account.get(), HttpStatus.OK);
//	}
	
	
//	@GetMapping("/accounts/{accountNumber}")
//	public ResponseEntity<?> findAccountBalance( @PathVariable("accountNumber")    String input){
//		Optional<Account>  account =repository.findByAccountNumber(input);
//		return new ResponseEntity<>(account.get(), HttpStatus.OK);
//	}
//	
	@GetMapping("/accounts")
	public ResponseEntity<?> findAccountBalance(@NotBlank @RequestParam("accountNumber")  String input)
			throws ResourceNotFoundException{
		
		
		
		return new ResponseEntity<>(repository.findByAccountNumber(input)
				.orElseThrow(()-> new ResourceNotFoundException(ACCOUNT_NOT_FOUND)), HttpStatus.OK);
	}
	
	// MIME Type // multipurpose internet mail extensions
	@PatchMapping(path ="/accounts/{accountNumber}",consumes = "application/json-patch+json")
	public ResponseEntity<?> updateDetails(@NotBlank @PathVariable("accountNumber") String accountNumber,
			@RequestBody JsonPatch patch) throws ResourceNotFoundException, JsonProcessingException, IllegalArgumentException, JsonPatchException{
		
		
		Account account =repository.findByAccountNumber(accountNumber)
		.orElseThrow(()-> new ResourceNotFoundException(ACCOUNT_NOT_FOUND));
		Account patchedAccount = applyPatchToAccount(patch, account);
		
		return new ResponseEntity<>(repository.save(patchedAccount),HttpStatus.OK);
		
		
		
	}
	
	
	private Account applyPatchToAccount(JsonPatch patch,Account targetAccount) throws IllegalArgumentException, JsonPatchException, JsonProcessingException {
		JsonNode patched = patch.apply(mapper.convertValue(targetAccount, JsonNode.class));
		return mapper.treeToValue(patched, Account.class);
		
	}
	
	 
	
	
}
