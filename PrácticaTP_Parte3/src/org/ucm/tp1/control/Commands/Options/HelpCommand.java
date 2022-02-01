package org.ucm.tp1.control.Commands.Options;

import org.ucm.tp1.control.Commands.Command;
import org.ucm.tp1.control.Commands.CommandGenerator;
import org.ucm.tp1.exceptions.CommandParseException;
import org.ucm.tp1.logic.Game;

public class HelpCommand extends Command {

	public static final String name = "help";
	public static final String shortcut = "h";
	public static final String details = "[h]elp";
	public static final String help = "show this help";
	public static final int numbOfArgs = 1;
	
	public HelpCommand() {
		super(name, shortcut, details, help, numbOfArgs);
	}

	@Override
	public boolean execute(Game game) {
		System.out.println(CommandGenerator.helpText());
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		return parseNoParamsCommand(commandWords);
	}

}
