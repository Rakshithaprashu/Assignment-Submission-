package sh.radical.samplecar.services;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sh.radical.samplecar.entities.Context;
import sh.radical.samplecar.entities.PagedResponse;
import sh.radical.samplecar.exceptions.CarNotFound;
import sh.radical.samplecar.inputs.CreateCarInput;
import sh.radical.samplecar.inputs.UpdateCarInput;
import sh.radical.samplecar.mappers.CarMapper;
import sh.radical.samplecar.models.Car;
import sh.radical.samplecar.repositories.CarRepository;

@Service
@Slf4j
public class CarService {

	@Autowired
	CarRepository carRepository;

	@Autowired
	CarMapper carMapper;

	public Car create(
		Context context,
		CreateCarInput createCarInput,
		String carId
	) {
		Car car = carMapper.createCar(context, createCarInput, carId);
		Car createdCar = carRepository.save(car);
		return createdCar;
	}

	public Car update(
		Context context,
		String carId,
		UpdateCarInput updateCarInput
	) {
		Optional<Car> existingCarData = carRepository.findById(carId);

		if (existingCarData.isEmpty()) {
			throw new CarNotFound();
		}
		Car updatedCar = carMapper.updateCar(
			context,
			carId,
			updateCarInput,
			existingCarData.get()
		);
		Car savedCar = carRepository.save(updatedCar);
		return savedCar;
	}

	public Car get(Context context, String carId) {
		Optional<Car> existingCarData = carRepository.findById(carId);
		if (existingCarData.isEmpty()) {
			throw new CarNotFound();
		}
		return existingCarData.get();
	}

	public PagedResponse<Car> getAll(
		Context context,
		String filters,
		String sort,
		Integer limit,
		Integer offset
	) {
		log.info("inside findAll service method");
		return carRepository.findAllCars(filters, sort, limit, offset);
	}

	public void delete(Context context, String carId) {
		Optional<Car> existingCarData = carRepository.findById(carId);

		if (existingCarData.isEmpty()) {
			throw new CarNotFound();
		}
		carRepository.deleteById(carId);
	}
}
