package bean;

import java.util.ArrayList;

import javax.swing.JFrame;

import ui.AbstractPanel;

public class Game {

	private ArrayList<Joueur> joueurList;
	private JFrame f;
	private ArrayList<AbstractPanel> listPanels;
	
	public Game(JFrame f, ArrayList<Joueur> joueurList) {
		this.joueurList=joueurList;
		this.f=f;
		setListPanels(new ArrayList<AbstractPanel>());
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

	public ArrayList<AbstractPanel> getListPanels() {
		return listPanels;
	}

	public void setListPanels(ArrayList<AbstractPanel> listPanels) {
		this.listPanels = listPanels;
	}
	
	
}
