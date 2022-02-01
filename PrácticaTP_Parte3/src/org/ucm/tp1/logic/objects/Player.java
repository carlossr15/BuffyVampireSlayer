package org.ucm.tp1.logic.objects;

import java.util.Random;

public class Player {
	
	public static final float COINS_FREQUENCY = (float) 0.5;
	public static final int MORE_COINS = 10;

	private int numCoins;
	private Random rand;
	
	public Player(int numCoins, Random rand) {
		this.numCoins = numCoins;
		this.rand = rand;
	}

	public int getNumCoins() {
		return numCoins;
	}
	
	public void setNumCoins(int coins) {
		numCoins = numCoins + coins;
	}

	public void receiveCoins() {
		if(rand.nextFloat() > COINS_FREQUENCY) numCoins = numCoins + 10; 
	}
	
}
