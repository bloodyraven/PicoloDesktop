package main;

import java.util.ArrayList;

import bean.Joueur;
import io.IO;

public class Main {

	public static void main(String[] args) {
		ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
		joueurs.add(new Joueur("Benoit"));
		joueurs.add(new Joueur("Cancan"));
		joueurs.add(new Joueur("Yann"));
		joueurs.add(new Joueur("Brandon"));
		new IO(joueurs);	
	}
	
}
