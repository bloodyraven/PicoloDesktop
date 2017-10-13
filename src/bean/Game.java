package bean;

import io.IO;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.JFrame;

import constants.Constants;
import controller.FrameController;
import ui.game.AbstractDisplayPanel;
import ui.game.BlankPanel;
import ui.game.DelayedQuestionPanel;
import ui.game.EnumerePanel;
import ui.game.JeuPanel;
import ui.game.TuPreferesPanel;
import ui.game.VirusPanel;

public class Game {

	private ArrayList<Joueur> joueurList;
	private JFrame f;
	private ArrayList<AbstractDisplayPanel> listPanels;
	private FrameController fc;
	
	private ArrayList<Question> blankQuestions;
	private ArrayList<Question> virusQuestions;
	private ArrayList<Question> enumereQuestions;
	private ArrayList<Question> jeuQuestions;
	private ArrayList<Question> prefereQuestions;
	
	public Game(JFrame f, ArrayList<Joueur> joueurList, ArrayList<File> fileList) {
		this.joueurList=joueurList;
		this.f=f;
		setListPanels(new ArrayList<AbstractDisplayPanel>());
		//LOAD ALL QUESTIONS
		IO io = new IO(joueurList, fileList);
		//SET FIRST LAYOUT
		fc = new FrameController(f, listPanels);
		//GENERATE SESSION QUESTIONS
		generatePanelList(io.getQuestionList());
		fc.setPanels(listPanels);
		fc.nextPanel();
	}
	
	private void generatePanelList(ArrayList<Question> questionList) {
		Collections.shuffle(questionList);
		int nb = Constants.NB_TURNS;
		if(questionList.size() < Constants.NB_TURNS) {
			nb = questionList.size();
		}
		ArrayList<Question> delayedQuestions = new ArrayList<Question>();
		for (int i = 0 ; i < nb ; i++) {
			Iterator<Question> it = delayedQuestions.iterator();
			while (it.hasNext()) {
				Question question=it.next();
				if(question.getDelay() - 1 == 0) {
					listPanels.add(new DelayedQuestionPanel(question.getName2(), fc));
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
				listPanels.add(new DelayedQuestionPanel(question.getName2(), fc));
			}
		}
	}
	
	private AbstractDisplayPanel getQuestionClass(Question q) {
		switch(q.getType()) {
			case "BLANK":return new BlankPanel(q, fc);
			case "VIRUS":return new VirusPanel(q, fc);
			case "ENUMERE":return new EnumerePanel(q, fc);
			case "PREFERE":return new TuPreferesPanel(q, fc);
			case "JEU":return new JeuPanel(q, fc);
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

	public FrameController getFc() {
		return fc;
	}

	public void setFc(FrameController fc) {
		this.fc = fc;
	}

	public ArrayList<Question> getBlankQuestions() {
		return blankQuestions;
	}

	public void setBlankQuestions(ArrayList<Question> blankQuestions) {
		this.blankQuestions = blankQuestions;
	}

	public ArrayList<Question> getVirusQuestions() {
		return virusQuestions;
	}

	public void setVirusQuestions(ArrayList<Question> virusQuestions) {
		this.virusQuestions = virusQuestions;
	}

	public ArrayList<Question> getEnumereQuestions() {
		return enumereQuestions;
	}

	public void setEnumereQuestions(ArrayList<Question> enumereQuestions) {
		this.enumereQuestions = enumereQuestions;
	}

	public ArrayList<Question> getJeuQuestions() {
		return jeuQuestions;
	}

	public void setJeuQuestions(ArrayList<Question> jeuQuestions) {
		this.jeuQuestions = jeuQuestions;
	}

	public ArrayList<Question> getPrefereQuestions() {
		return prefereQuestions;
	}

	public void setPrefereQuestions(ArrayList<Question> prefereQuestions) {
		this.prefereQuestions = prefereQuestions;
	}
	
}
