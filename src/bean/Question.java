package bean;

import java.util.ArrayList;

public class Question {

	private String name;
	private ArrayList<Joueur> joueurConcernes;
	
	public Question(String name, ArrayList<Joueur> joueurConcernes) {
		this.name=name;
		this.joueurConcernes=joueurConcernes;
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
}
