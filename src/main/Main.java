package main;

import io.IO;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;

import ui.menu.NewGamePanel;
import bean.Joueur;

public class Main {

	public static void main(String[] args) {
		//TODO remove MOCK JOUEURS
		ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
		joueurs.add(new Joueur("Benoit"));
		joueurs.add(new Joueur("Cancan"));
		joueurs.add(new Joueur("Yann"));
		joueurs.add(new Joueur("Brandon"));
		
		//TODO remove MOCK FILES
		ArrayList<File> files = new ArrayList<File>();
		files.add(new File("resources/picolo_nom.txt"));
		files.add(new File("resources/test.txt"));
		new IO(joueurs, files);

		JFrame f = new JFrame("Picolo Reborn");
		f.setSize(new Dimension(700, 450));
		f.setContentPane(new NewGamePanel(f));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
