package com.farukgenc.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.farukgenc.web.resources.ErrorResource;

@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * 
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = UserNotFoundException.class)
	public @ResponseBody ResponseEntity<ErrorResource> userNotFoundError(HttpServletRequest req,
			UserNotFoundException e) throws Exception {
		return new ResponseEntity<ErrorResource>(new ErrorResource(e.getDescription(), e.getUserCode()),
				HttpStatus.ALREADY_REPORTED);
	}

}
