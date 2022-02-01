package org.ucm.tp1.control.Commands.Options;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.ucm.tp1.control.Commands.Command;
import org.ucm.tp1.exceptions.CommandExecuteException;
import org.ucm.tp1.exceptions.CommandParseException;
import org.ucm.tp1.logic.Game;

public class SaveCommand extends Command{


	public static final String name = "save";
	public static final String shortcut = "s";
	public static final String details = "[S]ave <filename>";
	public static final String help = "Save the state of the game to a file.";
	public static final String succesMessage = "Game successfully saved to file ";
	public static final String dotDat = ".dat";
	public static final int numbOfArgs = 2;
	
	private String fileName;
	
	public SaveCommand() {
		super(name, shortcut, details, help, numbOfArgs);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException, IOException{
		String s = game.serialize();
		try (BufferedWriter buff = new BufferedWriter(new FileWriter(fileName))){
			buff.write(s);
			buff.close();
			System.out.println(succesMessage + fileName);
		}
		catch(IOException io) {
			throw new IOException(io.getMessage());
		}
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(matchCommandName(commandWords[0])) {
			if(commandWords.length == 2) {
				fileName = commandWords[1] + dotDat;
			}
			return parseNoParamsCommand(commandWords);
		}
		else return null;
	}
	
	

}
