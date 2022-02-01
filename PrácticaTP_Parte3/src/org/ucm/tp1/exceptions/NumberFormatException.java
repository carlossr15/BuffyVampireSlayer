package org.ucm.tp1.exceptions;

public class NumberFormatException extends CommandParseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9205432756853726889L;
	
	
	public NumberFormatException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NumberFormatException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NumberFormatException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NumberFormatException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NumberFormatException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
