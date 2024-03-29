package sh.radical.testrr.exceptions;

import java.lang.Exception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sh.radical.testrr.exceptions.ParserException;
import sh.radical.testrr.exceptions.PhoneNotFound;
import sh.radical.testrr.exceptions.ValidationException;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = PhoneNotFound.class)
	public ResponseEntity handlePhoneNotFound(PhoneNotFound exception) {
		return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = ParserException.class)
	public ResponseEntity parserExceptionHandler(
		ParserException parserException
	) {
		return new ResponseEntity(
			parserException.getMessage(),
			HttpStatus.BAD_REQUEST
		);
	}

	@ExceptionHandler(value = ValidationException.class)
	public ResponseEntity validationExceptionHandler(
		ValidationException validationException
	) {
		return new ResponseEntity(
			validationException.getMessage(),
			HttpStatus.BAD_REQUEST
		);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity genericExceptionHandler(Exception exception) {
		log.error("Unhandled exception", exception);
		return new ResponseEntity(
			"Internal Server Error",
			HttpStatus.INTERNAL_SERVER_ERROR
		);
	}
}
