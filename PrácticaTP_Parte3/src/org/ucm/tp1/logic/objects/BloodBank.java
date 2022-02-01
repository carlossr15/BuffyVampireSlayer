package org.ucm.tp1.logic.objects;

import org.ucm.tp1.logic.Game;

public class BloodBank extends Slayer{
	
	private int price;

	public BloodBank(int col, int row, int life, Game game, String symbol, int price) {
		super(col, row, life, game, symbol);
		this.price = price;
	}
	
	public void attack() {
		
	}
	
	public void move() {
		int percentage = price/10;
		game.setNumCoins(percentage);
	}
	
	public String serialize() {
		String s = super.serialize();
		 return s + ";" + price;
		
	}
	
	public String toString() {
		return symbol + " [" + price + "]";
	}

}
