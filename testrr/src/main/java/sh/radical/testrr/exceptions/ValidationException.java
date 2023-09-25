package sh.radical.testrr.exceptions;

import java.lang.Throwable;
import org.springframework.web.bind.annotation.ResponseStatus;
import sh.radical.testrr.exceptions.TestrrCustomException;

@ResponseStatus
public class ValidationException extends TestrrCustomException {

	public ValidationException() {
		super();
	}

	public ValidationException(String message) {
		super(message);
	}

	public ValidationException(String message, Throwable t) {
		super(message, t);
	}
}
