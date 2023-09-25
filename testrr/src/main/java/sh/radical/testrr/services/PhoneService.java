package sh.radical.testrr.services;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sh.radical.testrr.entities.Context;
import sh.radical.testrr.entities.PagedResponse;
import sh.radical.testrr.exceptions.PhoneNotFound;
import sh.radical.testrr.inputs.CreatePhoneInput;
import sh.radical.testrr.inputs.UpdatePhoneInput;
import sh.radical.testrr.mappers.PhoneMapper;
import sh.radical.testrr.models.Phone;
import sh.radical.testrr.repositories.PhoneRepository;

@Service
@Slf4j
public class PhoneService {

	@Autowired
	PhoneRepository phoneRepository;

	@Autowired
	PhoneMapper phoneMapper;

	public Phone create(
		Context context,
		CreatePhoneInput createPhoneInput,
		String phoneId
	) {
		Phone phone = phoneMapper.createPhone(
			context,
			createPhoneInput,
			phoneId
		);
		Phone createdPhone = phoneRepository.save(phone);
		return createdPhone;
	}

	public Phone update(
		Context context,
		String phoneId,
		UpdatePhoneInput updatePhoneInput
	) {
		Optional<Phone> existingPhoneData = phoneRepository.findById(phoneId);

		if (existingPhoneData.isEmpty()) {
			throw new PhoneNotFound();
		}
		Phone updatedPhone = phoneMapper.updatePhone(
			context,
			phoneId,
			updatePhoneInput,
			existingPhoneData.get()
		);
		Phone savedPhone = phoneRepository.save(updatedPhone);
		return savedPhone;
	}

	public Phone get(Context context, String phoneId) {
		Optional<Phone> existingPhoneData = phoneRepository.findById(phoneId);
		if (existingPhoneData.isEmpty()) {
			throw new PhoneNotFound();
		}
		return existingPhoneData.get();
	}

	public PagedResponse<Phone> getAll(
		Context context,
		String filters,
		String sort,
		Integer limit,
		Integer offset
	) {
		log.info("inside findAll service method");
		return phoneRepository.findAllPhones(filters, sort, limit, offset);
	}

	public void delete(Context context, String phoneId) {
		Optional<Phone> existingPhoneData = phoneRepository.findById(phoneId);

		if (existingPhoneData.isEmpty()) {
			throw new PhoneNotFound();
		}
		phoneRepository.deleteById(phoneId);
	}
}
