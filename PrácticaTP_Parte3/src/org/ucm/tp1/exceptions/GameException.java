package org.ucm.tp1.exceptions;

public class GameException extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8206922462497563662L;

	public GameException() {
		
	}
	
	public GameException(String message) {
		super(message);
	}
	
	public GameException(Throwable cause) {
		super(cause);
	}
	
	
	public GameException(String message, Throwable cause) {
	    super(message, cause);
	}

    public GameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    	super(message, cause, enableSuppression, writableStackTrace);
    }
	
	
	

}
