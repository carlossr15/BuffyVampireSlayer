package org.ucm.tp1.logic;


import org.ucm.tp1.logic.lists.GameObjectList;
import org.ucm.tp1.logic.objects.GameObject;

public class GameObjectBoard {
	
	private GameObjectList gameObjectList;
	
	public GameObjectBoard(Game game) {
		this.gameObjectList = new GameObjectList();
	}

	public void move() {
		gameObjectList.move();
	}
	
	public void removeDead() {
		gameObjectList.removeDeadObjects();
	}
	
	public boolean isEmpty(int row, int col) {
		if(gameObjectList.isEmpty(row, col)) return true;
		return false;
	}
	
	public boolean checkEndDefeat() {
		if(gameObjectList.checkEndDefeat()) return true;
		return false;
	}
	
	public boolean checkEndVictory() {
		if(gameObjectList.checkEndVictory()) return true;
		return false;
	}
	
	public void attack() {
		gameObjectList.attack();
	}
		
	public boolean samePosition(int row, int col) {
		if(gameObjectList.samePosition(row, col)) return true;
		return false;
	}
	
	public GameObject getGameObjectInPosition(int row, int col) {
		return gameObjectList.getGameObjectInPosition(row, col);
	}

	public void lightFlash() {
		gameObjectList.lightFlash();
	}

	public void garlicPush() {
		gameObjectList.garlicPush();
	}

	public void add(GameObject gameObject) {
		gameObjectList.add(gameObject);
	}
	
	public String serialize() {
		return gameObjectList.serialize();
	}

	public String getToStringInPosition(int row, int col) {
		return gameObjectList.getToStringInPosition(row, col);
	}


}
