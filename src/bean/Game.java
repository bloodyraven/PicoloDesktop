package bean;

import java.util.ArrayList;

import javax.swing.JFrame;

import ui.AbstractDisplayPanel;

public class Game {

	private ArrayList<Joueur> joueurList;
	private JFrame f;
	private ArrayList<AbstractDisplayPanel> listPanels;
	
	public Game(JFrame f, ArrayList<Joueur> joueurList) {
		this.joueurList=joueurList;
		this.f=f;
		setListPanels(new ArrayList<AbstractDisplayPanel>());
		//LOAD ALL QUESTIONS
		//GENERATE SESSION QUESTIONS
		//SET FIRST LAYOUT
	}

	public ArrayList<Joueur> getJoueurList() {
		return joueurList;
	}

	public void setJoueurList(ArrayList<Joueur> joueurList) {
		this.joueurList = joueurList;
	}

	public JFrame getF() {
		return f;
	}

	public void setF(JFrame f) {
		this.f = f;
	}

	public ArrayList<AbstractDisplayPanel> getListPanels() {
		return listPanels;
	}

	public void setListPanels(ArrayList<AbstractDisplayPanel> listPanels) {
		this.listPanels = listPanels;
	}
	
	
}
