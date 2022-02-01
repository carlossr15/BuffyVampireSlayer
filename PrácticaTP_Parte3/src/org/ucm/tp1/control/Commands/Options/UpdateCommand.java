package org.ucm.tp1.control.Commands.Options;

import org.ucm.tp1.control.Commands.Command;
import org.ucm.tp1.exceptions.CommandParseException;
import org.ucm.tp1.logic.Game;

public class UpdateCommand extends Command {
	
	public static final String name = "none";
	public static final String shortcut = "n";
	public static final String details = "[n]one | []";
	public static final String help = "update";
	public static final int numbOfArgs = 1;
	
	public UpdateCommand() {
		super(name, shortcut, details, help, numbOfArgs);
	}

	@Override
	public boolean execute(Game game) {
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(commandWords[0].equals("")) commandWords[0] = shortcut;
		return parseNoParamsCommand(commandWords);
	}

}
