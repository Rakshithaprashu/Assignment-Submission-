package sh.radical.testrr.exceptions;

import java.lang.RuntimeException;
import java.lang.Throwable;

public class TestrrCustomException extends RuntimeException {

	public TestrrCustomException() {
		super();
	}

	public TestrrCustomException(String message) {
		super(message);
	}

	public TestrrCustomException(String message, Throwable t) {
		super(message, t);
	}
}
