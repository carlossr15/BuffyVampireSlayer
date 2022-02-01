package org.ucm.tp1.logic.objects;

import org.ucm.tp1.logic.Game;

public class Vampire extends GameObject{
	
	public static final int HARM = 1;
	
	public static int NUMBER_OF_VAMPIRES;
	public static int VAMPIRES_ON_BOARD;
	public static boolean HAS_ARRIVED;

	private boolean canMove;	
	private int nextStep;
	
	public Vampire(int row, int col, int life, Game game, String symbol, boolean canMove) {
		super(row, col, life, game, symbol);
		this.canMove = canMove;
		VAMPIRES_ON_BOARD++;
		NUMBER_OF_VAMPIRES--;
		nextStep = 0;
	}
	
	public static void initVampires(Game game) {
		NUMBER_OF_VAMPIRES = game.getNumberOfVampires();
		VAMPIRES_ON_BOARD = 0;
		HAS_ARRIVED = false;
	}
	
	public static String getVampiresOnBoard() {
		return Integer.toString(VAMPIRES_ON_BOARD);
	}

	public static String getNumberOfVampires() {
		return Integer.toString(NUMBER_OF_VAMPIRES);
	}
	
	public void move() {
		if(canMove && game.isEmpty(getRow(), getCol() - 1)) {
			setCol(getCol() - 1);
			nextStep = 0;
			canMove = false;
			if(getCol() < 0) HAS_ARRIVED = true;
		}else if(canMove && !game.isEmpty(getRow(), getCol() - 1)) nextStep--;
		else canMove = true;
	}
	
	public void attack() {
		IAttack other = game.getAttackableInPosition(getCol() - 1, getRow());
		if (other != null )	other.receiveVampireAttack(HARM);
	}
	
	public boolean receiveSlayerAttack(int damage) {
		 setLife(getLife() - damage);
		 return true;
	}
	
	public boolean receiveGarlicPush() {
		 if(game.isEmpty(getRow(), getCol() + 1)) setCol(getCol() + 1);
		 if(getCol() >= game.dimX()) setLife(0);
		 canMove = false;
		 return true;
	}

	@Override
	public boolean receiveLightFlash() {
		setLife(0);
		return true;
	}
	
	public String serialize() {
		String s = super.serialize();
		if(canMove) { 
			s = s + ";" + nextStep;
		}
		else s = s + ";1";
		return s;
	}
	
	public boolean isAlive() {
		if(!super.isAlive()) {
			VAMPIRES_ON_BOARD--;
			return false;
		}
		return true;
	}
	
}
