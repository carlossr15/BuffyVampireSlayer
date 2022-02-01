package org.ucm.tp1.logic;

import java.util.Random;

import org.ucm.tp1.exceptions.CommandParseException;
import org.ucm.tp1.exceptions.DraculaIsAliveException;
import org.ucm.tp1.exceptions.NoMoreVampiresException;
import org.ucm.tp1.exceptions.NotEnoughCoinsException;
import org.ucm.tp1.exceptions.UnvalidPositionException;
import org.ucm.tp1.logic.objects.BloodBank;
import org.ucm.tp1.logic.objects.Dracula;
import org.ucm.tp1.logic.objects.ExplosiveVampire;
import org.ucm.tp1.logic.objects.IAttack;
import org.ucm.tp1.logic.objects.Player;
import org.ucm.tp1.logic.objects.Slayer;
import org.ucm.tp1.logic.objects.Vampire;
import org.ucm.tp1.view.GamePrinter;
import org.ucm.tp1.view.IPrintable;

public class Game implements IPrintable{
	
	public static final int INI_COINS = 50;
	public static final int INI_CYCLES = -1;
	public static final int SLAYER_PRICE = 50;
	public static final int LIGHTFLASH_PRICE = 50;
	public static final int GARLICPUSH_PRICE = 10;
	public static final int SUPER_COINS = 1000;
	public static final String DEFEAT_MESSAGE = "Vampires win!";
	public static final String VICTORY_MESSAGE = "Player wins";
	public static final String NUMB_OF_CYCLES = "Number of cycles: ";
	public static final String NUMB_OF_COINS = "Coins: ";
	public static final String REMAINING_VAMP = "Remaining vampires: ";
	public static final String VAMP_ON_THE_BOARD = "Vampires on the board: ";
	public static final String GAME_OVER = "[GAME OVER] Nobody wins...";	
	public static final String lightFlashNotEnoughCoins = "[ERROR]: Light Flash cost is 50: not enought coins";
	public static final String lightFlashFailed = "[ERROR]: Failed to light flash";
	public static final String garlicPushNotEnoughCoins = "[ERROR]: Garlic push cost is 10: not enought coins";
	public static final String garlicPushFailed = "[ERROR]: Failed to garlic push";
	public static final String positionError = "[ERROR]: Position (";
	public static final String unvalidPosition = "): Unvalid position\n";
	public static final String notEnoughCoinsSlayer = "[ERROR]: Defender cost is 50: Not enough coins\n";
	public static final String failedAddSlayer = "[ERROR]: Failed to add slayer";
	public static final String failedAddBank = "[ERROR]: Failed to add bank";
	public static final String failedAddVampire = "[ERROR]: Failed to add this vampire";
	public static final String noMoreVampires = "[ERROR]: No more remaining vampires left\n";
	public static final String draculaIsOnBoard = "[ERROR]: Dracula is already on board\n";
	public static final String defenderCostError = "[ERROR]: Defender cost is ";
	public static final String noECoins = ": Not enough coins\n";
	public static final String draculaIsAlive = "Dracula is alive\n";
	public static final String unvalidType = "[ERROR]: Unvalid type: [v]ampire [<type>] <x> <y>. Type = {\"\"|\"D\"|\"E\"}";

	
	public static final int SLAYER_LIFE = 3;
	public static final int VAMPIRE_LIFE = 5;
	public static final int BLOODBANK_LIFE = 1;
	public static final boolean CAN_MOVE = false;
	public static final String VampireSymbol = "V";
	public static final String SlayerSymbol = "S";
	public static final String DraculaSymbol = "D";
	public static final String ExplosiveSymbol = "EV";
	public static final String BloodSymbol = "B";	
	public static boolean LIGHTFLASH;
	public static boolean GARLICPUSH;
	
	private Level level;
	private Player player;
	private GameObjectBoard gameOb;
    private GamePrinter gamePrinter;
    private int cycles;
    private Random rand;
    
	public Game(Long seed, Level level){
		this.level = level;
		this.rand = new Random(seed);
		initGame(this);
	}
	
	public void initGame(Game game) {
		cycles = INI_CYCLES;
		player = new Player(INI_COINS, rand);
		gameOb = new GameObjectBoard(this);
		gamePrinter = new GamePrinter(game, level.getDimX(), level.getDimY());
		LIGHTFLASH = false;
		GARLICPUSH = false;
		Vampire.initVampires(this);
		Dracula.initDracula();
	}
	
	public void attack() {
		gameOb.attack();
	}

	public void update() {
		player.receiveCoins(); 
		gameOb.move();
	}
	
	public boolean isFinished() {
		if(gameOb.checkEndDefeat() || gameOb.checkEndVictory()) return true;
		return false;
	}
	
	public boolean isEmpty(int row, int col) {
		if(gameOb.isEmpty(row, col)) return true;
		else return false;
	}
	
	public int dimX() {
		return level.getDimX();
	}

	public int getNumberOfVampires() {
		return level.getNumberOfVampires();
	}
	
	public void addVampire() throws DraculaIsAliveException, UnvalidPositionException, NoMoreVampiresException{
		if(Vampire.NUMBER_OF_VAMPIRES > 0) createVampires(VampireSymbol);
		if(Vampire.NUMBER_OF_VAMPIRES > 0 && !Dracula.IS_DRACULA_ON_BOARD) createVampires(DraculaSymbol);
		if(Vampire.NUMBER_OF_VAMPIRES > 0) createVampires(ExplosiveSymbol);
	}
	
	public void createVampires(String symbol) throws UnvalidPositionException{
		if(rand.nextDouble() < level.getVampireFrequency()) {
			int row = rand.nextInt(level.getDimY());
			if(isEmpty(row, level.getDimX() - 1)) {
				if(symbol.equals(ExplosiveSymbol)) gameOb.add(new ExplosiveVampire(row, level.getDimX() - 1, VAMPIRE_LIFE, this, ExplosiveSymbol, CAN_MOVE));
				else if(symbol.equals(DraculaSymbol)) gameOb.add(new Dracula(row, level.getDimX() - 1, VAMPIRE_LIFE, this, DraculaSymbol, CAN_MOVE));
				else if(symbol.equals(VampireSymbol)) gameOb.add(new Vampire(row, level.getDimX() - 1, VAMPIRE_LIFE, this, VampireSymbol, CAN_MOVE));
			}
		}
	}
	
	public boolean addSlayer(int col, int row) throws UnvalidPositionException, NotEnoughCoinsException{
		if(col > level.getDimX() - 2 || row > level.getDimY() - 1 || col < 0 || row < 0) { //Comprueba si la columna y la fila donde quiere crear el usuario al slayer esta fuera de los limites
			throw new UnvalidPositionException(positionError + col + ", " + row + unvalidPosition + failedAddSlayer); 
		}
		else {
			if(player.getNumCoins() >= SLAYER_PRICE) { 
				if(isEmpty(row, col)) {
					player.setNumCoins(-SLAYER_PRICE); 
					gameOb.add(new Slayer(row, col, SLAYER_LIFE, this, SlayerSymbol));
					return true;
				}else throw new UnvalidPositionException(positionError + col + ", " + row + unvalidPosition + failedAddSlayer); 
			}else throw new NotEnoughCoinsException(notEnoughCoinsSlayer + failedAddSlayer); 
		
		}
	}
	
	public boolean addVampireType(int col, int row, String type) throws UnvalidPositionException, DraculaIsAliveException, NoMoreVampiresException, CommandParseException{
        if(col > level.getDimX() - 1 || row > level.getDimY() - 1 ||  col < 0 || row < 0) { //Comprueba si la columna y la fila donde quiere crear el usuario al slayer esta fuera de los limites
        	throw new UnvalidPositionException(positionError + col + ", " + row + unvalidPosition + failedAddVampire); 
        }else if(Vampire.NUMBER_OF_VAMPIRES <= 0) throw new NoMoreVampiresException(noMoreVampires + failedAddVampire); 
        else{
        	if(isEmpty(row, col)) {
	            if(type.equalsIgnoreCase("d")) {
	                if(Dracula.IS_DRACULA_ON_BOARD) {
	                	throw new DraculaIsAliveException(draculaIsOnBoard + failedAddVampire);
	                }else gameOb.add(new Dracula(row, col, VAMPIRE_LIFE, this, DraculaSymbol, CAN_MOVE));
	            }
	            else if(type.equalsIgnoreCase("e")) gameOb.add(new ExplosiveVampire(row, col, VAMPIRE_LIFE, this, ExplosiveSymbol, CAN_MOVE));
	            else if(type.equalsIgnoreCase("")) gameOb.add(new Vampire(row, col, VAMPIRE_LIFE, this, VampireSymbol, CAN_MOVE));
	            else throw new CommandParseException(unvalidType);
	            System.out.println(getInfo());
        	}else throw new UnvalidPositionException(positionError + col + ", " + row + unvalidPosition + failedAddVampire);
        }
        return false;
    }
	
	public boolean addBloodBank(int row, int col, int price) throws UnvalidPositionException, NotEnoughCoinsException{
		if((col <= level.getDimY() - 1 && row <= level.getDimX() - 1 &&  col >= 0 && row >= 0) && isEmpty(col, row)) {
			if(player.getNumCoins() >= price) {
				player.setNumCoins(-price);
				gameOb.add(new BloodBank(col, row, BLOODBANK_LIFE, this, BloodSymbol, price));
				return true;
			}
			throw new NotEnoughCoinsException(defenderCostError + price + noECoins + failedAddBank); 
		}
		throw new UnvalidPositionException(positionError + row + ", " + col + unvalidPosition + failedAddBank); 
	}
	
	public void removeDead() {
		gameOb.removeDead();
		LIGHTFLASH = false;
		GARLICPUSH = false;
	}
	
	public String getWinnerMessage() {
		if(gameOb.checkEndDefeat()) return DEFEAT_MESSAGE;
		else return VICTORY_MESSAGE;
	}
	
	public void exit() {
		System.out.println(GAME_OVER);
		System.exit(0);
	}
	
	public void reset() {
		initGame(this);
		addCycles();
		System.out.println(getInfo());
	}
	
	public void addCycles() {
		cycles++;
	}

	public void actualize() throws DraculaIsAliveException, UnvalidPositionException, NoMoreVampiresException {
  		update();
  		attack();
  		addVampire();
  		removeDead();
	}
	
	public IAttack getAttackableInPosition(int col, int row) {
		return gameOb.getGameObjectInPosition(row, col);
	}
	
	@Override
	public String getPositionToString(int x, int y) {
		if(gameOb.samePosition(x, y)) return gameOb.getToStringInPosition(x, y);
		return "";
	}

	public void setNumCoins(int coins) {
		player.setNumCoins(coins);
	}

	public void superCoins() {
		player.setNumCoins(SUPER_COINS);
		System.out.println(getInfo());
	}
	
	public boolean lightFlash() throws NotEnoughCoinsException{
		if(player.getNumCoins() >= LIGHTFLASH_PRICE) {
			player.setNumCoins(-LIGHTFLASH_PRICE);
			LIGHTFLASH = true;
			gameOb.lightFlash();	
			return true;
		}
		throw new NotEnoughCoinsException(lightFlashNotEnoughCoins + "\n" + lightFlashFailed);
	}

	public boolean garlicPush() throws NotEnoughCoinsException{
		if(player.getNumCoins() >= GARLICPUSH_PRICE) {
			player.setNumCoins(-GARLICPUSH_PRICE);
			GARLICPUSH = true;
			gameOb.garlicPush();
			return true;
		}
		throw new NotEnoughCoinsException(garlicPushNotEnoughCoins + "\n" + garlicPushFailed); 
	}

	
	public String serialize() {
		String z = "Cycles: " + cycles + "\nCoins: "  + player.getNumCoins() + "\nLevel: " + level.getName() + 
				"\nRemaining Vampires: " + Vampire.NUMBER_OF_VAMPIRES + "\nVampires on Board: " + 
				Vampire.VAMPIRES_ON_BOARD + "\n\nGame Object List: \n" + gameOb.serialize() + "\n"; 
		return z;
		
		
	}
	
	@Override
	public String getInfo() {
		String s = NUMB_OF_CYCLES + cycles+ "\n" + NUMB_OF_COINS + player.getNumCoins() + "\n" + REMAINING_VAMP + 
				Vampire.getNumberOfVampires() + "\n" + VAMP_ON_THE_BOARD + Vampire.getVampiresOnBoard() + "\n"; 
		if(Dracula.IS_DRACULA_ON_BOARD) s += draculaIsAlive;
		s += gamePrinter;
		return s;
	}


	
}
