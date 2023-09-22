package sh.radical.samplecar.exceptions;

import java.lang.Throwable;
import org.springframework.web.bind.annotation.ResponseStatus;
import sh.radical.samplecar.exceptions.SamplecarCustomException;

@ResponseStatus
public class CarNotFound extends SamplecarCustomException {

	public CarNotFound() {
		super();
	}

	public CarNotFound(String message) {
		super(message);
	}

	public CarNotFound(String message, Throwable t) {
		super(message, t);
	}
}
