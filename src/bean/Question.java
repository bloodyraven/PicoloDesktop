package bean;

import java.util.ArrayList;

public class Question {

	private String name;
	private int delay;
	private String name2;
	private ArrayList<Joueur> joueurConcernes;
	
	public Question(String name, ArrayList<Joueur> joueurConcernes) {
		this.name=name;
		this.joueurConcernes=joueurConcernes;
	}
	
	public Question(String name, ArrayList<Joueur> joueurConcernes, int delay, String name2) {
		this.name=name;
		this.joueurConcernes=joueurConcernes;
		this.delay=delay;
		this.name2=name2;
	}
	
	@Override
	public String toString() {
		String s = name+" { ";
		for (Joueur joueur : joueurConcernes) {
			s+=joueur.toString()+" ";
		}
		s+="}";
		return s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Joueur> getJoueurConcernes() {
		return joueurConcernes;
	}

	public void setJoueurConcernes(ArrayList<Joueur> joueurConcernes) {
		this.joueurConcernes = joueurConcernes;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}
}
