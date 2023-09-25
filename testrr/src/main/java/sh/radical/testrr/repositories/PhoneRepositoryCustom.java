package sh.radical.testrr.repositories;

import sh.radical.testrr.entities.PagedResponse;
import sh.radical.testrr.models.Phone;

public interface PhoneRepositoryCustom {
	PagedResponse<Phone> findAllPhones(
		String filters,
		String sort,
		Integer limit,
		Integer offset
	);
}
