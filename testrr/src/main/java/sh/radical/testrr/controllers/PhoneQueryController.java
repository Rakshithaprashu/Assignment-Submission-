package sh.radical.testrr.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sh.radical.testrr.entities.Context;
import sh.radical.testrr.entities.PagedResponse;
import sh.radical.testrr.models.Phone;
import sh.radical.testrr.services.PhoneService;

@Slf4j
@RestController
@RequestMapping(value = "/v1/phones")
public class PhoneQueryController {

	@Autowired
	PhoneService phoneService;

	@GetMapping(value = "/{phoneId}")
	public Phone get(
		@Parameter(hidden = true) Context context,
		@PathVariable(value = "phoneId") String phoneId
	) {
		log.info("Received a get request for Phone {} ", phoneId);
		Phone existingPhone = phoneService.get(context, phoneId);
		log.info("Get request for Phone {} is complete ", phoneId);
		return existingPhone;
	}

	@GetMapping
	public PagedResponse<Phone> selectAll(
		@Parameter(hidden = true) Context context,
		@RequestParam(value = "filters", required = false) String filters,
		@RequestParam(value = "sort", required = false) String sort,
		@RequestParam(value = "limit", required = false) Integer limit,
		@RequestParam(value = "offset", required = false) Integer offset
	) {
		log.info(
			"fetching values with pagelimit: {}, offset: {} for the filters: {} & sort: {}",
			limit,
			offset,
			filters,
			sort
		);
		var phonesPageResponse = phoneService.getAll(
			context,
			filters,
			sort,
			limit,
			offset
		);
		return phonesPageResponse;
	}
}
