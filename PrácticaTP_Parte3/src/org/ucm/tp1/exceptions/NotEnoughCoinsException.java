package org.ucm.tp1.exceptions;

public class NotEnoughCoinsException  extends CommandExecuteException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3418649053912320004L;

	public NotEnoughCoinsException(String message) {
		super(message);
	}

	public NotEnoughCoinsException() {
		super();
	}

	public NotEnoughCoinsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NotEnoughCoinsException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotEnoughCoinsException(Throwable cause) {
		super(cause);
	}



}
