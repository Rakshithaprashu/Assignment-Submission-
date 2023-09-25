package sh.radical.testrr.mappers;

import org.springframework.stereotype.Component;
import sh.radical.testrr.entities.Context;
import sh.radical.testrr.inputs.CreatePhoneInput;
import sh.radical.testrr.inputs.UpdatePhoneInput;
import sh.radical.testrr.models.Phone;

@Component
public class PhoneMapper {

	public Phone createPhone(
		Context context,
		CreatePhoneInput createPhoneInput,
		String phoneId
	) {
		Phone phone = new Phone();
		phone.setName(createPhoneInput.name);
		phone.setOwner(createPhoneInput.owner);
		phone.setPhoneType(createPhoneInput.phoneType);
		phone.setModel(createPhoneInput.model);
		phone.setPhoneId(phoneId);
		return phone;
	}

	public Phone updatePhone(
		Context context,
		String phoneId,
		UpdatePhoneInput updatePhoneInput,
		Phone existingPhone
	) {
		existingPhone.setName(updatePhoneInput.name);
		existingPhone.setOwner(updatePhoneInput.owner);
		existingPhone.setPhoneType(updatePhoneInput.phoneType);
		existingPhone.setModel(updatePhoneInput.model);
		return existingPhone;
	}
}
