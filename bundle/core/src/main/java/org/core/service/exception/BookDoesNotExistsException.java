package org.core.service.exception;

public class BookDoesNotExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7522942661557154724L;

	public BookDoesNotExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BookDoesNotExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BookDoesNotExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BookDoesNotExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public BookDoesNotExistsException() {
		// TODO Auto-generated constructor stub
	}

}
