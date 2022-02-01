package org.ucm.tp1.control.Commands.Options;

import org.ucm.tp1.control.Commands.Command;
import org.ucm.tp1.exceptions.CommandExecuteException;
import org.ucm.tp1.exceptions.CommandParseException;
import org.ucm.tp1.exceptions.NotEnoughCoinsException;
import org.ucm.tp1.logic.Game;

public class GarlicPushCommand extends Command{

	public static final String name = "garlic";
	public static final String shortcut = "g";
	public static final String details = "[g]arlic";
	public static final String help = "pushes back vampires";
	public static final int numbOfArgs = 1;
	
	public GarlicPushCommand() {
		super(name, shortcut, details, help, numbOfArgs);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try {
			game.garlicPush();
		}catch(NotEnoughCoinsException ex) {
			throw new CommandExecuteException(ex.getMessage());
		}
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		return parseNoParamsCommand(commandWords);
	}

}
