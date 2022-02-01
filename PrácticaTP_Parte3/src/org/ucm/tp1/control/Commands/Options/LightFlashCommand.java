package org.ucm.tp1.control.Commands.Options;

import org.ucm.tp1.control.Commands.Command;
import org.ucm.tp1.exceptions.CommandExecuteException;
import org.ucm.tp1.exceptions.CommandParseException;
import org.ucm.tp1.exceptions.NotEnoughCoinsException;
import org.ucm.tp1.logic.Game;

public class LightFlashCommand extends Command{

	public static final String name = "light";
	public static final String shortcut = "l";
	public static final String details = "[l]ight";
	public static final String help = "kills all the vampires";
	public static final int numbOfArgs = 1;
	
	
	public LightFlashCommand() {
		super(name, shortcut, details, help, numbOfArgs);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try {
			game.lightFlash();
		}
		catch(NotEnoughCoinsException noCoins) {
			throw new CommandExecuteException(noCoins.getMessage());
		}
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		return parseNoParamsCommand(commandWords);
	}

}
