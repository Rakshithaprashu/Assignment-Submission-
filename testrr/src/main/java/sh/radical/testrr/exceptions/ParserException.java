package sh.radical.testrr.exceptions;

import java.lang.Throwable;
import org.springframework.web.bind.annotation.ResponseStatus;
import sh.radical.testrr.exceptions.TestrrCustomException;

@ResponseStatus
public class ParserException extends TestrrCustomException {

	public ParserException() {
		super();
	}

	public ParserException(String message) {
		super(message);
	}

	public ParserException(String message, Throwable t) {
		super(message, t);
	}
}
