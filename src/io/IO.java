package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import bean.Joueur;
import bean.Question;

public class IO {
	
	private ArrayList<Question> questionList;

	public IO(ArrayList<Joueur> joueurs) {
		BufferedReader br = null;
		try {
			questionList = new ArrayList<Question>();
			br = new BufferedReader(new FileReader("resources/test.txt"));
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				int nb = StringUtils.countMatches(sCurrentLine, "@");
				ArrayList<Joueur> cloneJoueurs = new ArrayList<Joueur>(joueurs);
				ArrayList<Joueur> selectedJoueurs = new ArrayList<Joueur>();
				for (int i = 0; i < nb; i++) {
					int r  = (int) (Math.random() * joueurs.size() - 1);
					selectedJoueurs.add(cloneJoueurs.get(r));
					cloneJoueurs.remove(r);
				}
				for (int i = 0; i < selectedJoueurs.size(); i++) {
					sCurrentLine = sCurrentLine.replaceFirst("@", selectedJoueurs.get(i).toString());
				}
				questionList.add(new Question(sCurrentLine, selectedJoueurs));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {

				ex.printStackTrace();
			}
		}
		
		for (Question q : questionList) {
			System.out.println("question = "+q.toString());
		}
		
	}

	public ArrayList<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(ArrayList<Question> questionList) {
		this.questionList = questionList;
	}
}
