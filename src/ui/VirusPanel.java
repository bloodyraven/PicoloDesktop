package ui;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import controller.FrameController;
import bean.Question;

@SuppressWarnings("serial")
public class VirusPanel extends AbstractDisplayPanel {

	private Question question;

	public VirusPanel(Question question, FrameController fc) {
		super(question, fc);
		this.question=question;
		this.add(new JLabel("Virus"), BorderLayout.NORTH);
	}
	
	public String toString() {
		return "VirusPanel : "+question.getName();
	}

}
