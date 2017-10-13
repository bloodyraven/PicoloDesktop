package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.apache.commons.lang.StringUtils;

import constants.Constants;
import bean.Joueur;
import bean.Question;

public class IO {
	
	private ArrayList<Question> questionList;

	public IO(ArrayList<Joueur> joueurList, ArrayList<File> fileList) {
		questionList = new ArrayList<Question>();
		String actualCategory = "";
		BufferedReader br = null;
		String sCurrentLine = "";
		File currentFile = null;
		try {
			for (File file : fileList) {
				currentFile = file;
				br = new BufferedReader(new FileReader(file.getPath()));
				while ((sCurrentLine = br.readLine()) != null) {
					// Cas ligne vide
					if(sCurrentLine.trim().equals("")) {
						continue;
					}
					if(sCurrentLine.substring(0,1).equals("#")) {
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
					
					Pattern p = Pattern.compile("<[1-9]+>");
					Matcher m = p.matcher(splitLine[0]);
					if(m.find()) {
						splitLine[0] = splitLine[0].replace(m.group(0).trim(), getEffet(m.group(0).trim()));
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
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Constants.MSG_CORRUPTED_FILE+currentFile.getName(), "", JOptionPane.WARNING_MESSAGE);
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {

				ex.printStackTrace();
			}
		}
	}
	
	private String getEffet(String s) {
		switch (s) {
		case "<1>":
			String[] accents = {"allemand", "anglais", "chinois", "africain", "caille-ra", "du sud", "belge", "ch'ti"};
			return accents[((int)(Math.random()*accents.length))];

		default:
			return "";
		}
	}

	public ArrayList<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(ArrayList<Question> questionList) {
		this.questionList = questionList;
	}
}
