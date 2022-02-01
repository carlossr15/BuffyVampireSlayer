package org.ucm.tp1.control.Commands.Options;

import org.ucm.tp1.control.Commands.Command;
import org.ucm.tp1.exceptions.CommandExecuteException;
import org.ucm.tp1.exceptions.CommandParseException;
import org.ucm.tp1.exceptions.NotEnoughCoinsException;
import org.ucm.tp1.exceptions.UnvalidPositionException;
import org.ucm.tp1.logic.Game;

public class AddBloodBankCommand extends Command{
	public static final String name = "Bank";
	public static final String shortcut = "b";
	public static final String details = "[b]ank <x> <y> <z>";
	public static final String help = "add a blood bank with cost z in position x, y";
	public static final String unvalidArgument = "[ERROR]: Unvalid argument for add blood bank command, number expected: [b]ank <x> <y> <z>";
	public static final int numbOfArgs = 4;
	
	public int col;
	public int row;
	public int price;

	public AddBloodBankCommand() {
		super(name, shortcut, details, help, numbOfArgs);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try{
			game.addBloodBank(col, row, price);
		}catch(NotEnoughCoinsException noCoins){
			throw new CommandExecuteException(noCoins.getMessage());
		}catch(UnvalidPositionException un) {
			throw new CommandExecuteException(un.getMessage());
		}
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(matchCommandName(commandWords[0])) {
			if(commandWords.length == 4) {
				try {
					col = Integer.parseInt(commandWords[1]);
					row = Integer.parseInt(commandWords[2]);
					price = Integer.parseInt(commandWords[3]);
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
