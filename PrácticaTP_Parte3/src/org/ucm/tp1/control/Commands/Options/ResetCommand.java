package org.ucm.tp1.control.Commands.Options;

import org.ucm.tp1.control.Commands.Command;
import org.ucm.tp1.exceptions.CommandParseException;
import org.ucm.tp1.logic.Game;

public class ResetCommand extends Command {
	

	public static final String name = "reset";
	public static final String shortcut = "r";
	public static final String details = "[r]eset";
	public static final String help = "reset game";
	public static final int numbOfArgs = 1;
	
	public ResetCommand() {
		super(name, shortcut, details, help, numbOfArgs);
	}

	@Override
	public boolean execute(Game game) {
		game.reset();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		return parseNoParamsCommand(commandWords);
	}

}
