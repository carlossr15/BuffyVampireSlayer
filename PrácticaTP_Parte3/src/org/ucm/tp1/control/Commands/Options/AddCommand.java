package org.ucm.tp1.control.Commands.Options;

import org.ucm.tp1.control.Commands.Command;
import org.ucm.tp1.exceptions.CommandExecuteException;
import org.ucm.tp1.exceptions.CommandParseException;
import org.ucm.tp1.exceptions.NotEnoughCoinsException;
import org.ucm.tp1.exceptions.UnvalidPositionException;
import org.ucm.tp1.logic.Game;

public class AddCommand extends Command {
	
	public static final String name = "add";
	public static final String shortcut = "a";
	public static final String details = "[a]dd <x> <y>";
	public static final String help = "add a slayer in position x, y";
	static final String unvalidArgument = "[ERROR]: Unvalid argument for add slayer command, number expected: [a]dd <x> <y>";
	public static final int numbOfArgs = 3;
	
	public int col;
	public int row;

	public AddCommand() {
		super(name, shortcut, details, help, numbOfArgs);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try {
			game.addSlayer(col, row);
		}catch(UnvalidPositionException un) {
			throw new CommandExecuteException(un.getMessage());
		}catch(NotEnoughCoinsException no) {
			throw new CommandExecuteException(no.getMessage());
		}
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(matchCommandName(commandWords[0])) {
			if(commandWords.length == 3) {
				try {
					col = Integer.parseInt(commandWords[1]);
					row = Integer.parseInt(commandWords[2]);
				} 
				catch(NumberFormatException nfe){
					throw new CommandParseException(unvalidArgument);
				}
			}
			return parseNoParamsCommand(commandWords);
		}
		else return null;
	}

}
