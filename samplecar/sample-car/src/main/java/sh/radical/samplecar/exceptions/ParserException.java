package sh.radical.samplecar.exceptions;

import java.lang.Throwable;
import org.springframework.web.bind.annotation.ResponseStatus;
import sh.radical.samplecar.exceptions.SamplecarCustomException;

@ResponseStatus
public class ParserException extends SamplecarCustomException {

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
