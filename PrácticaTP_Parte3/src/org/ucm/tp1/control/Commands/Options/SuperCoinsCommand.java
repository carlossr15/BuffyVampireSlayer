package org.ucm.tp1.control.Commands.Options;

import org.ucm.tp1.control.Commands.Command;
import org.ucm.tp1.exceptions.CommandParseException;
import org.ucm.tp1.logic.Game;

public class SuperCoinsCommand extends Command{
	public static final String name = "coins";
	public static final String shortcut = "c";
	public static final String details = "[c]oins";
	public static final String help = "add 1000 coins";
	public static final int numbOfArgs = 1;
	
	public SuperCoinsCommand() {
		super(name, shortcut, details, help, numbOfArgs);
	}

	@Override
	public boolean execute(Game game) {
		game.superCoins();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		return parseNoParamsCommand(commandWords);
	}

}
