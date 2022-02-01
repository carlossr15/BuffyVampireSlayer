package org.ucm.tp1.exceptions;

public class CommandExecuteException extends GameException{
	private static final long serialVersionUID = 8206922462497563662L;

	public CommandExecuteException() {
		
	}
	
	public CommandExecuteException(String message) {
		super(message);
	}
	
	public CommandExecuteException(Throwable cause) {
		super(cause);
	}
	
	
	public CommandExecuteException(String message, Throwable cause) {
	    super(message, cause);
	}

    public CommandExecuteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    	super(message, cause, enableSuppression, writableStackTrace);
    }
	
	
	
}
