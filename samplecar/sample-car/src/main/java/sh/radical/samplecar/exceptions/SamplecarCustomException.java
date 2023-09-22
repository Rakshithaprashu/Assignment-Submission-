package sh.radical.samplecar.exceptions;

import java.lang.RuntimeException;
import java.lang.Throwable;

public class SamplecarCustomException extends RuntimeException {

	public SamplecarCustomException() {
		super();
	}

	public SamplecarCustomException(String message) {
		super(message);
	}

	public SamplecarCustomException(String message, Throwable t) {
		super(message, t);
	}
}
