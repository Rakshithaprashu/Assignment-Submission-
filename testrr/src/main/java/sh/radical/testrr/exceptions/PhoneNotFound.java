package sh.radical.testrr.exceptions;

import java.lang.Throwable;
import org.springframework.web.bind.annotation.ResponseStatus;
import sh.radical.testrr.exceptions.TestrrCustomException;

@ResponseStatus
public class PhoneNotFound extends TestrrCustomException {

	public PhoneNotFound() {
		super();
	}

	public PhoneNotFound(String message) {
		super(message);
	}

	public PhoneNotFound(String message, Throwable t) {
		super(message, t);
	}
}
