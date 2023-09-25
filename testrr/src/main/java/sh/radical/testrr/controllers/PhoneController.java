package sh.radical.testrr.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sh.radical.testrr.entities.Context;
import sh.radical.testrr.inputs.CreatePhoneInput;
import sh.radical.testrr.inputs.UpdatePhoneInput;
import sh.radical.testrr.models.Phone;
import sh.radical.testrr.services.PhoneService;

@Slf4j
@RestController
@RequestMapping(value = "/v1/phones")
public class PhoneController {

	@Autowired
	PhoneService phoneService;

	@PostMapping
	public ResponseEntity create(
		@Parameter(hidden = true) Context context,
		@Valid @RequestBody CreatePhoneInput createPhoneInput
	) {
		log.info("Received a new create request");
		var id = Phone.getNewPhoneId();
		phoneService.create(context, createPhoneInput, id);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Location", "/v1/phones/" + id);
		log.info("Create request for Phone - {} is complete", id);
		return new ResponseEntity(null, responseHeaders, HttpStatus.OK);
	}

	@PutMapping(value = "/{phoneId}")
	public ResponseEntity update(
		@Parameter(hidden = true) Context context,
		@PathVariable(value = "phoneId") String phoneId,
		@Valid @RequestBody UpdatePhoneInput updatePhoneInput
	) {
		log.info("Received a update request for Phone {} ", phoneId);
		phoneService.update(context, phoneId, updatePhoneInput);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Location", "/v1/phones/" + phoneId);
		log.info("Update request for Phone {} is complete", phoneId);
		return new ResponseEntity(null, responseHeaders, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{phoneId}")
	public void delete(
		@Parameter(hidden = true) Context context,
		@PathVariable(value = "phoneId") String phoneId
	) {
		log.info("Received a delete request for Phone {} ", phoneId);
		phoneService.delete(context, phoneId);
		log.info("Delete request completed for Phone {} ", phoneId);
	}
}
