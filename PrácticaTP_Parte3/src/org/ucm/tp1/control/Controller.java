package org.ucm.tp1.control;

import java.io.IOException;
import java.util.Scanner;

import org.ucm.tp1.control.Commands.Command;
import org.ucm.tp1.control.Commands.CommandGenerator;
import org.ucm.tp1.exceptions.GameException;
import org.ucm.tp1.logic.Game;

public class Controller {
	
	public final String prompt = "Command > ";
	public static final String unknownCommandMsg ="[ERROR]: Unknown command";
	public static final String gameOver ="[GAME OVER] ";
	
    private Game game;
    private Scanner scanner;
    
    public Controller(Game game, Scanner scanner) {
	    this.game = game;
	    this.scanner = scanner;
    }
    
    public void  printGame() {
    	System.out.println(game.getInfo());
    }
    
    public void run() throws IOException {
    	boolean refreshDisplay = true;

    	while (!game.isFinished()) {
	    	if (refreshDisplay ) {
	    		game.addCycles();
	    		printGame();
	    	}
	    	refreshDisplay = false;
	    	System.out.print(prompt);
	    	String s = scanner.nextLine();
	    	String[] parameters = s.toLowerCase().trim().split(" ");
	    	System.out.println("[DEBUG] Executing: " + s);
	    	try {
		    	Command command = CommandGenerator.parse(parameters);
		    	refreshDisplay = command.execute(game);
		    	if(refreshDisplay) game.actualize();
	    	}
	    	catch (GameException ex) {
	    		System.out.format(ex.getMessage() + " %n %n");
	    	}
    	}
			
        if (refreshDisplay) printGame();
        System.out.println (gameOver + game.getWinnerMessage());
    }
}
