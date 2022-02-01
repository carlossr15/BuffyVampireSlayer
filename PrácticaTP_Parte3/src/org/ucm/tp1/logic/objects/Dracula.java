package org.ucm.tp1.logic.objects;

import org.ucm.tp1.logic.Game;

public class Dracula extends Vampire{

	public static boolean IS_DRACULA_ON_BOARD;
	
	public Dracula(int row, int col, int life, Game game, String symbol, boolean canMove) {
		super(row, col, life, game, symbol, canMove);
		IS_DRACULA_ON_BOARD = true;
	}
	
	public static void initDracula() {
		IS_DRACULA_ON_BOARD = false;
	}

	public void attack() {
		IAttack other = game.getAttackableInPosition(getCol() - 1, getRow());
		if (other != null )	other.receiveDraculaAttack();
	}
	
	public boolean canRemove() {
		if(!isAlive()) {
			IS_DRACULA_ON_BOARD = false;
			VAMPIRES_ON_BOARD--;
			return true;
		}
		return false;
	}
	
	public boolean isAlive() {
		if(!super.isAlive()) {
			IS_DRACULA_ON_BOARD = false;
			return false;
		}
		return true;
		
	}
	
	public boolean receiveLightFlash() {
		return false;
	}

	

}
