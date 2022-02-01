package org.ucm.tp1.exceptions;

public class UnvalidPositionException extends CommandExecuteException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6282099019322825280L;

	public UnvalidPositionException(String message) {
		super(message);
	}

	public UnvalidPositionException() {
		super();
	}

	public UnvalidPositionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UnvalidPositionException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UnvalidPositionException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
