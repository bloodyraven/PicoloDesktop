package ui;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import controller.FrameController;
import bean.Question;

@SuppressWarnings("serial")
public class JeuPanel extends AbstractDisplayPanel {

	private Question question;

	public JeuPanel(Question question, FrameController fc) {
		super(question, fc);
		this.question=question;
		this.add(new JLabel("Jeu !"), BorderLayout.NORTH);
	}
	
	public String toString() {
		return "JeuPanel : "+question.getName();
	}

}
