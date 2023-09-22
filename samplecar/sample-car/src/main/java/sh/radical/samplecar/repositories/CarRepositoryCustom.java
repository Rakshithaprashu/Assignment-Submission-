package sh.radical.samplecar.repositories;

import sh.radical.samplecar.entities.PagedResponse;
import sh.radical.samplecar.models.Car;

public interface CarRepositoryCustom {
	PagedResponse<Car> findAllCars(
		String filters,
		String sort,
		Integer limit,
		Integer offset
	);
}
