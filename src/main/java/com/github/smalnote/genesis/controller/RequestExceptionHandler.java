package com.github.smalnote.genesis.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.github.smalnote.genesis.model.ErrorInfo;

@RestControllerAdvice
public class RequestExceptionHandler {
	private static final Logger logger = LogManager.getLogger(RequestExceptionHandler.class);

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResponseEntity<ErrorInfo> noHandlerFound(HttpServletRequest req, NoHandlerFoundException ex) {

		String errorURL = req.getRequestURL().toString();
		String errorMessage = "request URL not supported: " + ex.getRequestURL();

		ErrorInfo errorInfo = new ErrorInfo(errorURL, errorMessage);
		logger.error(errorInfo);
		
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResponseEntity<ErrorInfo> methodNotSupported(HttpServletRequest req, HttpRequestMethodNotSupportedException ex) {

		String errorURL = req.getRequestURL().toString();
		String errorMessage = "request method not supported: " + ex.getMethod();

		ErrorInfo errorInfo = new ErrorInfo(errorURL, errorMessage);
		logger.error(errorInfo);
		
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResponseEntity<ErrorInfo> unhandledException(HttpServletRequest req, Exception ex) {

		String errorURL = req.getRequestURL().toString();
		String errorMessage = "unhandled exception: " + ex;

		ErrorInfo errorInfo = new ErrorInfo(errorURL, errorMessage);
		logger.error(errorInfo);
		
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
