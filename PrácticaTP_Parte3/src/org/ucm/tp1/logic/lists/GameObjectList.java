package org.ucm.tp1.logic.lists;

import java.util.ArrayList;
import org.ucm.tp1.logic.objects.GameObject;
import org.ucm.tp1.logic.objects.Vampire;

public class GameObjectList {
	
	private ArrayList<GameObject> gameobjects;
	
	public GameObjectList() {
		this.gameobjects = new ArrayList<GameObject>();
	}
	
	public void add(GameObject gameObject) {
		gameobjects.add(gameObject);
	}
	
	public void move() {
		for(int i = 0; i < gameobjects.size(); i++) {
			gameobjects.get(i).move();
		}
	}
	
	public boolean checkEndVictory() {	
		if(Vampire.VAMPIRES_ON_BOARD == 0 && Vampire.NUMBER_OF_VAMPIRES == 0) return true;
		return false;
	}

	public boolean checkEndDefeat() {
		if(Vampire.HAS_ARRIVED) return true;
		return false;
	}
	
	public void removeDeadObjects() { 
		for(int i = gameobjects.size() - 1; i >= 0; i--) {
			if(!gameobjects.get(i).isAlive()) gameobjects.remove(i);
		}
	}
	
	public boolean isEmpty(int row, int col) {
		for(GameObject i: gameobjects) {
			if(i.samePosition(row, col)) return false;
		}
		return true;
	}

	public boolean samePosition(int row, int col) {
		for(GameObject i: gameobjects) {
			if(i.samePosition(row, col)) return true;
		}
		return false;
	}

	public GameObject getGameObjectInPosition(int row, int col) {
		for(GameObject i: gameobjects) {
			if(i.samePosition(row, col)) return i;
		}
		return null;
	}

	public void attack() {
		for(GameObject i: gameobjects) {
			if(i.getLife() > 0) i.attack();
		}
	}

	public void lightFlash() {
		for(GameObject i: gameobjects) {
			i.receiveLightFlash();
		}		
	}

	public void garlicPush() {
		for(GameObject i: gameobjects) {
			i.receiveGarlicPush(); 
		}
	}
	
	public String serialize() {
		String s = "";
		for(GameObject i: gameobjects) {
			s += i.serialize() + "\n";
		}
		return s;
	}

	public String getToStringInPosition(int row, int col) {
		for(GameObject i: gameobjects) {
			if(i.samePosition(row, col)) return i.toString();
		}
		return null;
	}

}
