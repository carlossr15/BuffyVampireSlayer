package org.ucm.tp1.control.Commands;


import java.io.IOException;

import org.ucm.tp1.exceptions.CommandExecuteException;
import org.ucm.tp1.exceptions.CommandParseException;
import org.ucm.tp1.logic.Game;

public abstract class Command {

	  protected final String name;
	  protected final String shortcut;
	  private final String details; 
	  private final String help;
	  private final int numbOfArgs;

	  
	  protected static final String incorrectNumberOfArgsMsg = "[ERROR]: Incorrect number of arguments for ";
	  protected static final String commandPrompt = " command: ";
	  
	  public Command(String name,  String shortcut, String details, String help, int numbOfArgs){    
	    this.name = name;
	    this.shortcut = shortcut;
	    this.details = details;
	    this.help = help;
	    this.numbOfArgs = numbOfArgs;
	  }
	  
	  public abstract boolean execute(Game game) throws CommandExecuteException, CommandParseException, IOException;
	  
	  public abstract Command parse(String[] commandWords) throws CommandParseException;
	  
	  protected boolean matchCommandName(String name) {
		    return this.shortcut.equalsIgnoreCase(name) || 
		        this.name.equalsIgnoreCase(name);
	  }
	  
	  protected Command parseNoParamsCommand(String[] words) throws CommandParseException {
			  if (matchCommandName(words[0])) {
				  if (words.length != numbOfArgs) throw new CommandParseException(incorrectNumberOfArgsMsg + name + commandPrompt + details);
				  else return this;
			  }
			  return null;
	  }

	  
	  public String helpText(){
		  	return details + ": " + help + "\n";
	  }
}