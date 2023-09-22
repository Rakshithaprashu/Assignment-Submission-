package sh.radical.samplecar.exceptions;

import java.lang.Throwable;
import org.springframework.web.bind.annotation.ResponseStatus;
import sh.radical.samplecar.exceptions.SamplecarCustomException;

@ResponseStatus
public class ValidationException extends SamplecarCustomException {

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
