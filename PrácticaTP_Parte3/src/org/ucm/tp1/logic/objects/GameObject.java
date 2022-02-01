package org.ucm.tp1.logic.objects;

import org.ucm.tp1.logic.Game;

public abstract class GameObject implements IAttack{
	
	private int row;
	private int col;
	private int life;
	protected String symbol;
	protected Game game;
	
	public GameObject(int row, int col, int life, Game game, String symbol) {
		this.row = row;
		this.col = col;
		this.life = life;
		this.game = game;
		this.symbol = symbol;
	}

	public abstract void move();
	
	public boolean isEmpty(int col, int row) {
		if(this.row == row && this.col == col) return false;
		else return true;
	}

	public boolean isAlive() {
		return life > 0;
	}

	public boolean samePosition(int row, int col) {
		if(getRow() == row && getCol() == col) return true;
		else return false;
	}

	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public int getLife() {
		return life;
	}
	
	public void setCol(int col) {
		this.col = col;
	}

	public void setLife(int life) {
		this.life = life;	
	}
	
	public String serialize() {
		return symbol +";" + col +";" + row + ";" + life;
	}
	
	public String toString() {
		return symbol + " [" + life + "]";
	}
	
}
