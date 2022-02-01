package org.ucm.tp1.exceptions;

public class NoMoreVampiresException  extends CommandExecuteException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8662635685063504952L;

	public NoMoreVampiresException(String message) {
		super(message);
	}

	public NoMoreVampiresException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoMoreVampiresException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NoMoreVampiresException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoMoreVampiresException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
