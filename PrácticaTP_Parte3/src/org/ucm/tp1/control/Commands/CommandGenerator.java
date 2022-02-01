package org.ucm.tp1.control.Commands;

import org.ucm.tp1.control.Commands.Options.AddBloodBankCommand;
import org.ucm.tp1.control.Commands.Options.AddCommand;
import org.ucm.tp1.control.Commands.Options.AddVampireCommand;
import org.ucm.tp1.control.Commands.Options.ExitCommand;
import org.ucm.tp1.control.Commands.Options.GarlicPushCommand;
import org.ucm.tp1.control.Commands.Options.HelpCommand;
import org.ucm.tp1.control.Commands.Options.LightFlashCommand;
import org.ucm.tp1.control.Commands.Options.ResetCommand;
import org.ucm.tp1.control.Commands.Options.SaveCommand;
import org.ucm.tp1.control.Commands.Options.SerializeCommand;
import org.ucm.tp1.control.Commands.Options.SuperCoinsCommand;
import org.ucm.tp1.control.Commands.Options.UpdateCommand;
import org.ucm.tp1.exceptions.CommandParseException;

public class CommandGenerator {
	
	public static final String unknownCommandMsg ="Unknown command";

	private static Command[] availableCommands = {
			new AddCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new UpdateCommand(),
			new GarlicPushCommand(),
			new LightFlashCommand(),
			new AddBloodBankCommand(),
			new SuperCoinsCommand(),
			new AddVampireCommand(),
			new SaveCommand(), 
			new SerializeCommand()
			};
	
	
	public static Command parse(String[] parameters) throws CommandParseException {
		for(int i = 0; i < availableCommands.length; i++) {
			Command parsedC = availableCommands[i].parse(parameters);
			if(parsedC != null ) {
				return parsedC;	
			}
		}	
		throw new CommandParseException("[ERROR]: " + unknownCommandMsg);
	}
	
	public static String helpText() {
		String helpText = "Available commands:\n";
		for(int i = 0; i < availableCommands.length; i++) {
			helpText += availableCommands[i].helpText();
		}
		return helpText;
	}
}
