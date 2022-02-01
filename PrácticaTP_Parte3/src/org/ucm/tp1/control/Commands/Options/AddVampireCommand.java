package org.ucm.tp1.control.Commands.Options;

import org.ucm.tp1.control.Commands.Command;
import org.ucm.tp1.exceptions.CommandExecuteException;
import org.ucm.tp1.exceptions.CommandParseException;
import org.ucm.tp1.exceptions.DraculaIsAliveException;
import org.ucm.tp1.exceptions.NoMoreVampiresException;
import org.ucm.tp1.exceptions.UnvalidPositionException;
import org.ucm.tp1.logic.Game;

public class AddVampireCommand extends Command {
	
	public static final String name = "vampire";
	public static final String shortcut = "v";
	public static final String details = "[v]ampire [<type>] <x> <y>. Type = {\"\"|\"D\"|\"E\"}";
	public static final String help = "add a vampire in position x, y";
	static final String unvalidArgument = "[ERROR]: Unvalid argument for add vampire command, number expected: [v]ampire [<type>] <x> <y>. Type = {\"\"|\"D\"|\"E\"}";
	public static int numbOfArgs = 4;
	
	public int col;
	public int row;
	public String type;

	public AddVampireCommand() {
		super(name, shortcut, details, help, numbOfArgs);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException, CommandParseException {
		try {
			game.addVampireType(col, row, type);
		}catch(UnvalidPositionException un) {
			throw new CommandExecuteException(un.getMessage());
		}catch(DraculaIsAliveException is) {
			throw new CommandExecuteException(is.getMessage());
		}catch(NoMoreVampiresException no) {
			throw new CommandExecuteException(no.getMessage());
		}
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(matchCommandName(commandWords[0])) {
			if(commandWords.length == 4) { 
				try {
					type = commandWords[1];
					col = Integer.parseInt(commandWords[2]);
					row = Integer.parseInt(commandWords[3]);
				} 
				catch(NumberFormatException nfe){
					throw new CommandParseException(unvalidArgument);
				}
			}else if(commandWords.length == 3) {
				try {
					type = "";
					col = Integer.parseInt(commandWords[1]);
					row = Integer.parseInt(commandWords[2]);
				}
				catch(NumberFormatException nfe){
					throw new CommandParseException(unvalidArgument);
				}
				String aux[] = new String[4];
				aux[0] = commandWords[0];
				return parseNoParamsCommand(aux);
			}
			return parseNoParamsCommand(commandWords);
		}
		else return null;
	}
}
