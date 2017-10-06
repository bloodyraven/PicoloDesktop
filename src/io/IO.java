package io;

import java.io.BufferedReader;
import java.io.File;
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
					int r  = (int) (Math.random() * (joueurs.size() - i));
					selectedJoueurs.add(cloneJoueurs.get(r));
					cloneJoueurs.remove(r);
				}
				for (int i = 0; i < selectedJoueurs.size(); i++) {
					sCurrentLine = sCurrentLine.replaceFirst("@", selectedJoueurs.get(i).toString());
				}
				questionList.add(new Question(sCurrentLine, selectedJoueurs, ""));
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
	
	public IO(ArrayList<Joueur> joueurList, ArrayList<File> fileList) {
		questionList = new ArrayList<Question>();
		String actualCategory = "";
		BufferedReader br = null;
		try {
			for (File file : fileList) {
				br = new BufferedReader(new FileReader(file.getPath()));
				String sCurrentLine;
				while ((sCurrentLine = br.readLine()) != null) {
					// Test catégorie
					if(sCurrentLine.trim().equals("")) {
						continue;
					}
					if(sCurrentLine.contains("#")) {
						actualCategory = sCurrentLine.replace("#", "");
						continue;
					}
					String[] splitLine = sCurrentLine.split("/");
					int nb = StringUtils.countMatches(splitLine[0], "@");
					if(nb>joueurList.size()) {
						continue;
					}
					ArrayList<Joueur> cloneJoueurs = new ArrayList<Joueur>(joueurList);
					ArrayList<Joueur> selectedJoueurs = new ArrayList<Joueur>();
					for (int i = 0; i < nb; i++) {
						int r  = (int) (Math.random() * (joueurList.size() - i));
						selectedJoueurs.add(cloneJoueurs.get(r));
						cloneJoueurs.remove(r);
					}
					boolean multipleText = false;
					try {
						multipleText = null != splitLine[2];
					} catch (Exception e) {}
					for (int i = 0; i < selectedJoueurs.size(); i++) {
						splitLine[0] = splitLine[0].replaceFirst("@", selectedJoueurs.get(i).toString());
						if(multipleText)
							splitLine[2] = splitLine[2].replaceFirst("@", selectedJoueurs.get(i).toString());
					}
					if(!multipleText) {
						questionList.add(new Question(splitLine[0], selectedJoueurs, actualCategory));
					} else {
						questionList.add(new Question(splitLine[0], selectedJoueurs, Integer.parseInt(splitLine[1]), splitLine[2], actualCategory));
					}
				}
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
//		for (Question q : questionList) {
//			System.out.println(q.toString());
//		}
	}

	public ArrayList<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(ArrayList<Question> questionList) {
		this.questionList = questionList;
	}
}
