package org.ucm.tp1.exceptions;


public class CommandParseException extends GameException{
	private static final long serialVersionUID = 8206922462497563662L;

	public CommandParseException() {
		
	}
	
	public CommandParseException(String message) {
		super(message);
	}
	
	public CommandParseException(Throwable cause) {
		super(cause);
	}
	
	
	public CommandParseException(String message, Throwable cause) {
	    super(message, cause);
	}

    public CommandParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    	super(message, cause, enableSuppression, writableStackTrace);
    }
	
	
	




}
