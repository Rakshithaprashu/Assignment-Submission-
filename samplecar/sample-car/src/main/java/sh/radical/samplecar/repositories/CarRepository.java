package sh.radical.samplecar.repositories;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import sh.radical.samplecar.models.Car;
import sh.radical.samplecar.repositories.CarRepositoryCustom;

@Repository
public interface CarRepository
	extends
		PagingAndSortingRepository<Car, String>,
		CrudRepository<Car, String>,
		QuerydslPredicateExecutor<Car>,
		CarRepositoryCustom {}
