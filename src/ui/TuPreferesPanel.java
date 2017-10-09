package ui;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import controller.FrameController;
import bean.Question;

@SuppressWarnings("serial")
public class TuPreferesPanel extends AbstractDisplayPanel {

	private Question question;

	public TuPreferesPanel(Question question, FrameController fc) {
		super(question, fc);
		this.question=question;
		this.add(new JLabel("Tu préfères..."), BorderLayout.NORTH);
	}
	
	public String toString() {
		return "TuPreferePanel : "+question.getName();
	}
}
