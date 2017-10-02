package bean;

import java.util.ArrayList;

public class Game {

	private ArrayList<Joueur> joueurList = new ArrayList<Joueur>();
	
	public Game() {
		
	}

	public ArrayList<Joueur> getJoueurList() {
		return joueurList;
	}

	public void setJoueurList(ArrayList<Joueur> joueurList) {
		this.joueurList = joueurList;
	}
	
	
}
