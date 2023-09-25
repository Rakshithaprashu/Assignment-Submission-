package sh.radical.testrr.repositories;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import sh.radical.testrr.models.Phone;
import sh.radical.testrr.repositories.PhoneRepositoryCustom;

@Repository
public interface PhoneRepository
	extends
		PagingAndSortingRepository<Phone, String>,
		CrudRepository<Phone, String>,
		QuerydslPredicateExecutor<Phone>,
		PhoneRepositoryCustom {}
