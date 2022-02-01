package org.ucm.tp1.logic.objects;

import org.ucm.tp1.logic.Game;

public class Slayer extends GameObject {
	
	public static final int HARM = 1;
	
	public Slayer(int row, int col, int life, Game game, String symbol) {
		super(row, col, life, game, symbol);
	}

	public void attack() {
		for(int i = getCol() + 1; i < game.dimX(); i++) {
			IAttack other = game.getAttackableInPosition(i, getRow());
			if (other != null )	{
				if(other.receiveSlayerAttack(HARM)) break;
			}
		}
	}

	public boolean receiveVampireAttack(int damage) {
		 setLife(getLife() - damage);
		 return true;
	}
	
	public boolean receiveDraculaAttack() {
		setLife(0);
		return true;
	}
	
	@Override
	public void move() {
		
	}
	
}
