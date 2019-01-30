package org.dao.exception;

public class EntryNotFoundExpcetion extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4807089964794548661L;

	public EntryNotFoundExpcetion(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public EntryNotFoundExpcetion(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EntryNotFoundExpcetion(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EntryNotFoundExpcetion(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public EntryNotFoundExpcetion() {
		// TODO Auto-generated constructor stub
	}

}
