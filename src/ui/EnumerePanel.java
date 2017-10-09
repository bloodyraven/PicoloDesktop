package ui;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import controller.FrameController;
import bean.Question;

@SuppressWarnings("serial")
public class EnumerePanel extends AbstractDisplayPanel {

	private Question question;

	public EnumerePanel(Question question, FrameController fc) {
		super(question, fc);
		this.question=question;
		this.add(new JLabel("Enumère..."), BorderLayout.NORTH);
	}
	
	public String toString() {
		return "EnumerePanel : "+question.getName();
	}

}
