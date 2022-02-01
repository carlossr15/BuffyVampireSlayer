package org.ucm.tp1.logic.objects;

import org.ucm.tp1.logic.Game;

public class ExplosiveVampire extends Vampire{
	

	public ExplosiveVampire(int row, int col, int life, Game game, String symbol, boolean canMove) {
		super(row, col, life, game, symbol, canMove);
	}
	
	public boolean receiveSlayerAttack(int damage) {
		super.receiveSlayerAttack(damage);
		if(getLife() == 0) Boom();
		return true;
	}
	
	public void Boom() {
		for(int i = getRow() - 1; i <= getRow() + 1; i++) {
			for(int j = getCol() - 1; j <= getCol() + 1; j++) {
				IAttack other = game.getAttackableInPosition(j, i);
				if (other != null) {
					other.receiveSlayerAttack(HARM);
				}
			}
		}
	}
}
