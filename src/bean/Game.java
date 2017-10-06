package bean;

import io.IO;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.JFrame;

import ui.AbstractDisplayPanel;
import ui.BlankPanel;
import ui.DelayedQuestionPanel;
import ui.EnumerePanel;
import ui.JeuPanel;
import ui.TuPreferesPanel;
import ui.VirusPanel;

public class Game {

	private ArrayList<Joueur> joueurList;
	private JFrame f;
	private ArrayList<AbstractDisplayPanel> listPanels;
	
	public Game(JFrame f, ArrayList<Joueur> joueurList, ArrayList<File> fileList) {
		this.joueurList=joueurList;
		this.f=f;
		setListPanels(new ArrayList<AbstractDisplayPanel>());
		//LOAD ALL QUESTIONS
		IO io = new IO(joueurList, fileList);
		//GENERATE SESSION QUESTIONS
		generatePanelList(io.getQuestionList());
		//SET FIRST LAYOUT
	}
	
	private void generatePanelList(ArrayList<Question> questionList) {
		Collections.shuffle(questionList);
		ArrayList<Question> delayedQuestions = new ArrayList<Question>();
		for (int i = 0 ; i < 10 ; i++) {
			Iterator<Question> it = delayedQuestions.iterator();
			while (it.hasNext()) {
				Question question=it.next();
				if(question.getDelay() - 1 == 0) {
					listPanels.add(new DelayedQuestionPanel(question.getName2()));
					it.remove();
				}
			}
			for (Question question : delayedQuestions) {
				question.setDelay(question.getDelay()-1);
			}
			Question q = questionList.get(i);
			listPanels.add(getQuestionClass(q));
			if(q.getDelay()>0) {
				delayedQuestions.add(q);
			}
		}
		if(delayedQuestions.size()>0) {
			for (Question question : delayedQuestions) {
				listPanels.add(new DelayedQuestionPanel(question.getName2()));
			}
		}
		int cpt = 0;
		for (AbstractDisplayPanel abstractDisplayPanel : listPanels) {
			System.out.println(cpt++ +" "+abstractDisplayPanel.toString());
		}
	}
	
	private AbstractDisplayPanel getQuestionClass(Question q) {
		switch(q.getType()) {
			case "BLANK":return new BlankPanel(q);
			case "VIRUS":return new VirusPanel(q);
			case "ENUMERE":return new EnumerePanel(q);
			case "PREFERE":return new TuPreferesPanel(q);
			case "JEU":return new JeuPanel(q);
			default:return null;
		}
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
