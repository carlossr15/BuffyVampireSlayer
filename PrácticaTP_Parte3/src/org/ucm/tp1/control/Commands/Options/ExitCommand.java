package org.ucm.tp1.control.Commands.Options;

import org.ucm.tp1.control.Commands.Command;
import org.ucm.tp1.exceptions.CommandParseException;
import org.ucm.tp1.logic.Game;

public class ExitCommand extends Command {
	
	public static final String name = "exit";
	public static final String shortcut = "e";
	public static final String details = "[e]xit";
	public static final String help = "exit game";
	public static final int numbOfArgs = 1;
	
	public ExitCommand() {
		super(name, shortcut, details, help, numbOfArgs);
	}

	@Override
	public boolean execute(Game game) {
		game.exit();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		return parseNoParamsCommand(commandWords);
	}

}
