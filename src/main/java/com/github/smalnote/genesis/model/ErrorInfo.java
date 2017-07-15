package com.github.smalnote.genesis.model;

public class ErrorInfo {
	private String errorURL;
	private String errorMessage;

	public ErrorInfo() {
	}

	public ErrorInfo(String errorURL, String errorMessage) {
		this.errorURL = errorURL;
		this.errorMessage = errorMessage;
	}

	public String getErrorURL() {
		return errorURL;
	}

	public void setErrorURL(String errorURL) {
		this.errorURL = errorURL;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String toString() {
		return String.format("errorURL: %s, errorMessage: %s", errorURL, errorMessage);
	}
}
