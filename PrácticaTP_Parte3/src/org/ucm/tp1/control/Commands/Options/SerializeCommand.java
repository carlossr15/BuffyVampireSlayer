package org.ucm.tp1.control.Commands.Options;

import org.ucm.tp1.control.Commands.Command;
import org.ucm.tp1.exceptions.CommandParseException;
import org.ucm.tp1.logic.Game;

public class SerializeCommand  extends Command{
	
	public static final String name = "serialize";
	public static final String shortcut = "z";
	public static final String details = "Seriali[z]e";
	public static final String help = "Serializes the board.";
	public static final int numbOfArgs = 1;
	
	public SerializeCommand() {
		super(name, shortcut, details, help, numbOfArgs);
	}

	@Override
	public boolean execute(Game game) {
		System.out.println(game.serialize());
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		return parseNoParamsCommand(commandWords);
	}
}
