package com.github.smalnote.genesis.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.github.smalnote.genesis.model.ErrorInfo;

@RestControllerAdvice
public class NoHandlerFoundHandler {
	private static final Logger logger = LogManager.getLogger(NoHandlerFoundHandler.class);

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResponseEntity<ErrorInfo> requestHandlingNoHandlerFound(HttpServletRequest req, NoHandlerFoundException ex) {

		String errorURL = req.getRequestURL().toString();
		String errorMessage = "no handler found";

		ErrorInfo errorInfo = new ErrorInfo(errorURL, errorMessage);
		logger.error(errorInfo);
		
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.BAD_REQUEST);
	}
}
