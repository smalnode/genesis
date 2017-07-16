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
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorInfo noHandlerFound(HttpServletRequest req, NoHandlerFoundException ex) {

		String errorURL = req.getRequestURL().toString();
		String errorMessage = "request URL not supported: " + ex.getRequestURL();

		ErrorInfo errorInfo = new ErrorInfo(errorURL, errorMessage);
		logger.error(errorInfo);
		
		return errorInfo;
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
	@ResponseBody
	public ErrorInfo methodNotSupported(HttpServletRequest req, HttpRequestMethodNotSupportedException ex) {

		String errorURL = req.getRequestURL().toString();
		String errorMessage = "request method not supported: " + ex.getMethod();

		ErrorInfo errorInfo = new ErrorInfo(errorURL, errorMessage);
		logger.error(errorInfo);
		
		return errorInfo;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorInfo unhandledException(HttpServletRequest req, Exception ex) {

		String errorURL = req.getRequestURL().toString();
		String errorMessage = "unhandled exception: " + ex;

		ErrorInfo errorInfo = new ErrorInfo(errorURL, errorMessage);
		logger.error(errorInfo);
		
		return errorInfo;
	}
}
