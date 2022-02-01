package org.ucm.tp1.exceptions;

public class DraculaIsAliveException  extends CommandExecuteException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1882286245365295135L;

	public DraculaIsAliveException(String message) {
		super(message);
	}

	public DraculaIsAliveException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DraculaIsAliveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DraculaIsAliveException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DraculaIsAliveException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
