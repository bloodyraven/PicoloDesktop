package main;

import io.IO;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import ui.NewGamePanel;
import bean.Joueur;

public class Main {

	public static void main(String[] args) {
		ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
		joueurs.add(new Joueur("Benoit"));
		joueurs.add(new Joueur("Cancan"));
		joueurs.add(new Joueur("Yann"));
		joueurs.add(new Joueur("Brandon"));
		new IO(joueurs);
		
		JFrame f = new JFrame("Picolo Reborn");
		f.setSize(new Dimension(700, 450));
		f.setContentPane(new NewGamePanel(f));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	
}
